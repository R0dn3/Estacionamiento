package Servlets;

import Models.Pago;
import DAO.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;

@WebServlet("/RegistrarPagoServlet")
public class RegistrarPagoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String placa = request.getParameter("placa");
        String metodoPago = request.getParameter("metodo_pago");

        if (placa == null || placa.trim().isEmpty() || metodoPago == null || metodoPago.trim().isEmpty()) {
            request.setAttribute("error", "Por favor, complete todos los campos.");
            request.getRequestDispatcher("caja.jsp").forward(request, response);
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            // Buscar ingreso por placa
            String ingresoQuery = "SELECT i.id, i.fecha_ingreso, t.clase_vehiculo, t.precio_hora " +
                                  "FROM ingresos i " +
                                  "INNER JOIN tarifas t ON i.clase_vehiculo_id = t.id " +
                                  "WHERE i.placa = ?";
            PreparedStatement ingresoPs = connection.prepareStatement(ingresoQuery);
            ingresoPs.setString(1, placa);
            ResultSet rs = ingresoPs.executeQuery();

            if (rs.next()) {
                Pago pago = new Pago();
                pago.setIngresoId(rs.getInt("id"));
                pago.setPlaca(placa);
                pago.setClaseVehiculo(rs.getString("clase_vehiculo"));
                pago.setFechaIngreso(rs.getTimestamp("fecha_ingreso").toLocalDateTime());
                double precioHora = rs.getDouble("precio_hora");

                // Calcular el monto
                LocalDateTime fechaSalida = LocalDateTime.now();
                pago.setFechaSalida(fechaSalida);
                Duration duracion = Duration.between(pago.getFechaIngreso(), fechaSalida);
                long horas = Math.max(1, duracion.toHours()); // Cobrar al menos 1 hora
                double montoTotal = horas * precioHora;
                pago.setMonto(montoTotal);
                pago.setMetodoPago(metodoPago);
                pago.setFechaPago(LocalDateTime.now());

                // Registrar el pago
                String pagoQuery = "INSERT INTO pagos (ingreso_id, monto, metodo_pago, fecha_pago) VALUES (?, ?, ?, ?)";
                PreparedStatement pagoPs = connection.prepareStatement(pagoQuery);
                pagoPs.setInt(1, pago.getIngresoId());
                pagoPs.setDouble(2, montoTotal);
                pagoPs.setString(3, metodoPago);
                pagoPs.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                pagoPs.executeUpdate();

                // Enviar datos al JSP
                request.setAttribute("pago", pago);
            } else {
                request.setAttribute("error", "No se encontró ningún ingreso para la placa ingresada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al registrar el pago. Intente más tarde.");
        }

        request.getRequestDispatcher("caja.jsp").forward(request, response);
    }
}


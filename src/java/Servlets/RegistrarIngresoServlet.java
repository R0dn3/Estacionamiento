package Servlets;

import DAO.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/RegistrarIngresoServlet")
public class RegistrarIngresoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String placa = request.getParameter("placa");
        String claseVehiculoIdParam = request.getParameter("clase-vehiculo");

        if (placa == null || placa.trim().isEmpty() || claseVehiculoIdParam == null || claseVehiculoIdParam.isEmpty()) {
            response.sendRedirect("Ingresos.jsp?error=Datos incompletos.");
            return;
        }

        try {
            int claseVehiculoId = Integer.parseInt(claseVehiculoIdParam);

            // Obtener fecha y hora actuales
            LocalDateTime fechaHoraActual = LocalDateTime.now();
            String fechaIngreso = fechaHoraActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            try (Connection con = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO ingresos (placa, fecha_ingreso, clase_vehiculo_id) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, placa);
                ps.setString(2, fechaIngreso);
                ps.setInt(3, claseVehiculoId);
                ps.executeUpdate();

                response.sendRedirect("Ingresos.jsp?success=true");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("Ingresos.jsp?error=Clase de vehículo inválida.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("Ingresos.jsp?error=Error al registrar ingreso.");
        }
    }
}


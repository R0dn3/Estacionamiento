package Servlets;

import DAO.DatabaseConnection;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/TarifaServlet")
public class TarifaServlet extends HttpServlet {
    private Connection conn;

    @Override
    public void init() throws ServletException {
        try {
            conn = DatabaseConnection.getConnection(); // Conexión a la base de datos
        } catch (Exception e) {
            throw new ServletException("Error al conectar a la base de datos", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                // Añadir tarifa
                String claseVehiculo = request.getParameter("claseVehiculo");
                BigDecimal precioHora = new BigDecimal(request.getParameter("precioHora"));
                BigDecimal precioDia = new BigDecimal(request.getParameter("precioDia"));

                String insertQuery = "INSERT INTO tarifas (clase_vehiculo, precio_hora, precio_dia) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(insertQuery);
                ps.setString(1, claseVehiculo);
                ps.setBigDecimal(2, precioHora);
                ps.setBigDecimal(3, precioDia);
                ps.executeUpdate();
                response.sendRedirect("tarifa.jsp");
            } else if ("edit".equals(action)) {
                // Editar tarifa
                int id = Integer.parseInt(request.getParameter("id"));
                String claseVehiculo = request.getParameter("claseVehiculo");
                BigDecimal precioHora = new BigDecimal(request.getParameter("precioHora"));
                BigDecimal precioDia = new BigDecimal(request.getParameter("precioDia"));

                String updateQuery = "UPDATE tarifas SET clase_vehiculo = ?, precio_hora = ?, precio_dia = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(updateQuery);
                ps.setString(1, claseVehiculo);
                ps.setBigDecimal(2, precioHora);
                ps.setBigDecimal(3, precioDia);
                ps.setInt(4, id);
                ps.executeUpdate();
                response.sendRedirect("tarifa.jsp");
            } else if ("delete".equals(action)) {
                // Eliminar tarifa
                int id = Integer.parseInt(request.getParameter("id"));
                String deleteQuery = "DELETE FROM tarifas WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(deleteQuery);
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("tarifa.jsp");
            }
        } catch (SQLException e) {
            throw new ServletException("Error al realizar operación en la base de datos", e);
        }
    }
}

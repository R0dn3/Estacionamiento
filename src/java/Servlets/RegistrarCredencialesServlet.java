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

@WebServlet("/RegistrarCredencialesServlet")
public class RegistrarCredencialesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Se debe encriptar la contraseña, por seguridad
        // Por ejemplo, usando BCrypt (esto es solo un ejemplo, deberías implementarlo según tu proyecto)
        String encryptedPassword = password; // Aquí deberías encriptar la contraseña

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO admin_users (username, password) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, encryptedPassword); // Guarda la contraseña encriptada
                stmt.executeUpdate();
                response.sendRedirect("registro_credenciales_exitoso.jsp"); // Redirige a una página de éxito
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // En caso de error, redirige a una página de error
        }
    }
}

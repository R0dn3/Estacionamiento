package DAO;

import JSF.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {

    // Método para validar la contraseña del administrador
    public boolean validateAdminPassword(String adminPassword) {
        String query = "SELECT * FROM admin_users WHERE password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, adminPassword);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Devuelve true si hay un registro que coincide con la contraseña
        } catch (SQLException e) {
            System.out.println("Error al validar la contraseña: " + e.getMessage());
            return false;
        }
    }

    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

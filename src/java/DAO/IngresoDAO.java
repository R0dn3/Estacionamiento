package DAO;

import Models.Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngresoDAO {
    private static final String INSERT_INGRESO = "INSERT INTO ingresos (placa, clase_vehiculo, fecha_hora_ingreso) VALUES (?, ?, ?)";

    public boolean registrarIngreso(Ingreso ingreso) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_INGRESO)) {
            ps.setString(1, ingreso.getPlaca());
            ps.setString(2, ingreso.getClaseVehiculo());
            ps.setTimestamp(3, ingreso.getFechaHoraIngreso());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package DAO;

import Models.Salida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalidaDAO {
    private static final String BUSCAR_POR_PLACA = 
        "SELECT i.placa, i.fecha_ingreso, t.clase_vehiculo " +
        "FROM ingresos i " +
        "JOIN tarifas t ON i.clase_vehiculo_id = t.id " +
        "WHERE i.placa = ?";

    public Salida buscarPorPlaca(String placa) {
        Salida salida = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(BUSCAR_POR_PLACA)) {

            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                salida = new Salida();
                salida.setPlaca(rs.getString("placa"));
                salida.setFechaIngreso(rs.getTimestamp("fecha_ingreso").toLocalDateTime());
                salida.setClaseVehiculo(rs.getString("clase_vehiculo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salida;
    }
}

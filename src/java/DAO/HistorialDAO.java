package DAO;

import Models.Historial;
import java.sql.*;
import java.util.ArrayList;

public class HistorialDAO {

    public ArrayList<Historial> obtenerHistorial(String placa, String claseVehiculo) throws SQLException {
        ArrayList<Historial> historial = new ArrayList<>();
        String query = "SELECT i.placa, t.clase_vehiculo, i.fecha_ingreso " +
                       "FROM ingresos i " +
                       "JOIN tarifas t ON i.clase_vehiculo_id = t.id " +
                       "WHERE 1=1";

        // Agregar filtros dinámicamente
        if (placa != null && !placa.isEmpty()) {
            query += " AND i.placa = ?";
        }
        if (claseVehiculo != null && !claseVehiculo.isEmpty()) {
            query += " AND t.clase_vehiculo = ?";
        }

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            int index = 1;

            // Asignar parámetros dinámicamente
            if (placa != null && !placa.isEmpty()) {
                stmt.setString(index++, placa);
            }
            if (claseVehiculo != null && !claseVehiculo.isEmpty()) {
                stmt.setString(index++, claseVehiculo);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    historial.add(new Historial(
                        rs.getString("placa"),
                        rs.getString("clase_vehiculo"),
                        rs.getString("fecha_ingreso")
                    ));
                }
            }
        }

        return historial;
    }
}

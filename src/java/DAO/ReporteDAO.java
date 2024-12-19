package DAO;

import Models.Reporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    private static final String SQL_BASE = 
        "SELECT i.placa, t.clase_vehiculo, i.fecha_ingreso, i.fecha_salida " +
        "FROM ingresos i " +
        "JOIN tarifas t ON i.clase_vehiculo_id = t.id ";

    public List<Reporte> obtenerReportes(String placa, String claseVehiculo) {
        List<Reporte> reportes = new ArrayList<>();
        StringBuilder query = new StringBuilder(SQL_BASE);

        // Filtros
        if (placa != null && !placa.isEmpty()) {
            query.append("WHERE i.placa = ?");
        }

        if (claseVehiculo != null && !claseVehiculo.isEmpty()) {
            if (placa != null && !placa.isEmpty()) {
                query.append(" AND ");
            } else {
                query.append("WHERE ");
            }
            query.append("t.clase_vehiculo = ?");
        }

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query.toString())) {

            int index = 1;

            // Establecemos los parámetros de la consulta
            if (placa != null && !placa.isEmpty()) {
                ps.setString(index++, placa);
            }

            if (claseVehiculo != null && !claseVehiculo.isEmpty()) {
                ps.setString(index, claseVehiculo);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reporte reporte = new Reporte();
                reporte.setPlaca(rs.getString("placa"));
                reporte.setClaseVehiculo(rs.getString("clase_vehiculo"));
                reporte.setFechaIngreso(rs.getTimestamp("fecha_ingreso").toLocalDateTime());
                reporte.setFechaSalida(rs.getTimestamp("fecha_salida") != null ? rs.getTimestamp("fecha_salida").toLocalDateTime() : null);
                reportes.add(reporte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reportes;
    }
}

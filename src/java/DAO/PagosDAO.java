package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DAO.DatabaseConnection;

public class PagosDAO {
    private static final String REGISTRAR_PAGO = 
        "INSERT INTO pagos (ingreso_id, monto, metodo_pago, fecha_pago) VALUES (?, ?, ?, NOW())";

    public boolean registrarPago(int ingresoId, String metodoPago) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(REGISTRAR_PAGO)) {

            // Ejemplo de cálculo de monto (esto lo calculas dinámicamente según tu lógica)
            double monto = 15.00; // Temporal, debe calcularse.

            ps.setInt(1, ingresoId);
            ps.setDouble(2, monto);
            ps.setString(3, metodoPago);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

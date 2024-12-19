package Servlets;

import DAO.IngresoDAO;
import Models.Ingreso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/IngresoServlet")
public class IngresoServlet extends HttpServlet {
    private final IngresoDAO ingresoDAO = new IngresoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String placa = request.getParameter("placa");
        String claseVehiculo = request.getParameter("clase-vehiculo");
        Timestamp fechaHoraIngreso = new Timestamp(System.currentTimeMillis());

        Ingreso ingreso = new Ingreso(placa, claseVehiculo, fechaHoraIngreso);
        boolean registrado = ingresoDAO.registrarIngreso(ingreso);

        if (registrado) {
            response.sendRedirect("Ingresos.jsp?success=true");
        } else {
            response.sendRedirect("Ingresos.jsp?error=true");
        }
    }
}

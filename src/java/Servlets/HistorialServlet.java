package Servlets;

import DAO.HistorialDAO;
import Models.Historial;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/HistorialServlet")
public class HistorialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Constructor
    public HistorialServlet() {
        super();
    }

    // Handle GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String placa = request.getParameter("placa");
        String claseVehiculo = request.getParameter("claseVehiculo");
        HistorialDAO historialDAO = new HistorialDAO();
        ArrayList<Historial> historial = new ArrayList<>();
        String error = "";

        try {
            historial = historialDAO.obtenerHistorial(placa, claseVehiculo);
            if (historial.isEmpty()) {
                error = "No se encontraron registros para los filtros especificados.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            error = "Error al obtener el historial de ingresos.";
        }

        // Pasar el historial y el mensaje de error al JSP
        request.setAttribute("historial", historial);
        request.setAttribute("error", error);

        // Redirigir a la vista (historial.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("historial.jsp");
        dispatcher.forward(request, response);
    }
}


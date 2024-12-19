package Servlets;

import DAO.ReporteDAO;
import Models.Reporte;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ReporteServlet")
public class ReporteServlet extends HttpServlet {
    private final ReporteDAO reporteDAO = new ReporteDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String placa = request.getParameter("placa");
        String claseVehiculo = request.getParameter("claseVehiculo");

        // Obtener los reportes según los filtros proporcionados
        List<Reporte> reportes = reporteDAO.obtenerReportes(placa, claseVehiculo);

        // Verificar si se encontraron reportes
        if (reportes.isEmpty()) {
            request.setAttribute("error", "No se encontraron resultados.");
        }

        request.setAttribute("reportes", reportes);
        request.getRequestDispatcher("historial.jsp").forward(request, response);
    }
}


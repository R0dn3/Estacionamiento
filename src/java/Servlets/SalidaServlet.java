package Servlets;

import DAO.SalidaDAO;
import Models.Salida;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SalidaServlet")
public class SalidaServlet extends HttpServlet {
    private final SalidaDAO salidaDAO = new SalidaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String placa = request.getParameter("placa");

        if (placa == null || placa.trim().isEmpty()) {
            request.setAttribute("error", "Por favor, ingrese una placa.");
        } else {
            Salida salida = salidaDAO.buscarPorPlaca(placa);
            if (salida != null) {
                request.setAttribute("salida", salida);
            } else {
                request.setAttribute("error", "No se encontró ningún registro para la placa ingresada.");
            }
        }

        request.getRequestDispatcher("salida.jsp").forward(request, response);
    }
}

package Servlets;

import DAO.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtiene la contraseña del formulario
        String adminPassword = request.getParameter("adminPassword");

        // Crea una instancia de UserDAO para validar la contraseña
        UserDAO userDAO = new UserDAO();
        boolean isValid = userDAO.validateAdminPassword(adminPassword);

        // Si la contraseña es válida, redirige al dashboard
        if (isValid) {
            response.sendRedirect("dashboard.jsp");
        } else {
            // Si la contraseña es incorrecta, muestra un mensaje de error
            request.setAttribute("errorMessage", "Contraseña incorrecta.");
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }
    }
}


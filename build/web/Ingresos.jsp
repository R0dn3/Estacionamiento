<%@page import="DAO.DatabaseConnection"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ingreso de Vehículos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dashboard.css">
</head>
<body>
    <header>
        <div class="header-left">
            <span class="icon">☰</span> 
            <span class="title">EN LÍNEA</span> | <span class="admin-icon">🚗</span> ADMIN
        </div>
        <div class="header-right">
            <span>MONEDA: PEN</span>
            <span>Jueves, 5 de septiembre del 2024</span>
            <span>05:00:15 PM</span>
        </div>
    </header>
    
    <div class="container">
        <!-- Sidebar -->
        <nav class="sidebar">
            <ul>
                <li><a href="dashboard.jsp">INICIO</a></li>
                <li><a href="tarifa.jsp">TARIFAS</a></li>
                <li><a href="Ingresos.jsp">INGRESOS</a></li>
                <li><a href="salida.jsp">SALIDA</a></li>
                <li><a href="caja.jsp">CAJA</a></li>
                <li><a href="historial.jsp">REPORTES</a></li>
            </ul>
        </nav>

        <!-- Contenido principal -->
        <main class="content">
            <h2>Ingreso de Vehículos</h2>
            <!-- Mensaje de éxito o error -->
            <%
                String success = request.getParameter("success");
                String error = request.getParameter("error");
                if (success != null) {
            %>
                <p style="color: green;">Ingreso registrado exitosamente.</p>
            <%
                } else if (error != null) {
            %>
                <p style="color: red;">Error: <%= error %></p>
            <%
                }
            %>

            <div class="form-container">
                <form action="RegistrarIngresoServlet" method="POST">
                    <label for="placa">Ingrese Placa del Vehículo:</label>
                    <input type="text" id="placa" name="placa" required>

                    <label for="clase-vehiculo">Seleccione Clase del Vehículo:</label>
                    <select id="clase-vehiculo" name="clase-vehiculo" required>
                        <option value="">Selección</option>
                        <% 
                            try (Connection con = DatabaseConnection.getConnection();
                                 Statement stmt = con.createStatement();
                                 ResultSet rs = stmt.executeQuery("SELECT id, clase_vehiculo FROM tarifas")) {
                                while (rs.next()) {
                        %>
                            <option value="<%= rs.getInt("id") %>"><%= rs.getString("clase_vehiculo") %></option>
                        <% 
                                }
                            } catch (SQLException e) {
                                out.println("<option value=''>Error al cargar clases de vehículos</option>");
                                e.printStackTrace();
                            } 
                        %>
                    </select>

                    <p>HORA: <span id="hora"></span></p>
                    <p>FECHA: <span id="fecha"></span></p>

                    <button type="submit" class="btn-ingresar">INGRESAR</button>
                </form>
            </div>
        </main>
    </div>

    <script>
        // Actualizar la hora y fecha automáticamente
        const updateTime = () => {
            const now = new Date();
            document.getElementById('hora').textContent = now.toLocaleTimeString();
            document.getElementById('fecha').textContent = now.toLocaleDateString('es-ES', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' });
        };
        setInterval(updateTime, 1000);
        updateTime();
    </script>
</body>
</html>

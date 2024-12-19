<%@page import="DAO.DatabaseConnection"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Tarifas</title>
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

        <main>
            <div class="tarifa-panel">
                <h2>Gestión de Tarifas</h2>
                
                <!-- Formulario para Añadir Tarifa -->
                <div class="tarifa-actions">
                    <form action="TarifaServlet" method="POST">
                        <input type="hidden" name="action" value="add">
                        <input type="text" name="claseVehiculo" placeholder="Clase de Vehículo" required>
                        <input type="number" step="0.01" name="precioHora" placeholder="Precio por Hora" required>
                        <input type="number" step="0.01" name="precioDia" placeholder="Precio por Día" required>
                        <button type="submit" class="btn-nueva">Añadir Tarifa</button>
                    </form>
                </div>

                <!-- Tabla de Tarifas -->
                <table class="tarifa-table">
                    <thead>
                        <tr>
                            <th>ELIMINAR</th>
                            <th>EDITAR</th>
                            <th>CLASE DE VEHÍCULO</th>
                            <th>PRECIO POR HORA</th>
                            <th>PRECIO POR DÍA</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            Connection conn = null;
                            PreparedStatement ps = null;
                            ResultSet rs = null;

                            try {
                                conn = DatabaseConnection.getConnection();
                                ps = conn.prepareStatement("SELECT * FROM tarifas");
                                rs = ps.executeQuery();

                                while (rs.next()) {
                        %>
                        <tr>
                            <!-- Eliminar Tarifa -->
                            <td>
                                <form action="TarifaServlet" method="POST">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                                    <button type="submit" class="btn-eliminar">🗑</button>
                                </form>
                            </td>
                            <!-- Editar Tarifa -->
                            <td>
                                <form action="TarifaServlet" method="POST">
                                    <input type="hidden" name="action" value="edit">
                                    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                                    <input type="text" name="claseVehiculo" value="<%= rs.getString("clase_vehiculo") %>" required>
                                    <input type="number" step="0.01" name="precioHora" value="<%= rs.getBigDecimal("precio_hora") %>" required>
                                    <input type="number" step="0.01" name="precioDia" value="<%= rs.getBigDecimal("precio_dia") %>" required>
                                    <button type="submit" class="btn-editar">✏</button>
                                </form>
                            </td>
                            <td><%= rs.getString("clase_vehiculo") %></td>
                            <td><%= rs.getBigDecimal("precio_hora") %></td>
                            <td><%= rs.getBigDecimal("precio_dia") %></td>
                        </tr>
                        <%
                                }
                            } catch (SQLException e) {
                                out.println("<tr><td colspan='5'>Error al cargar tarifas.</td></tr>");
                            } finally {
                                if (rs != null) rs.close();
                                if (ps != null) ps.close();
                                if (conn != null) conn.close();
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</body>
</html>

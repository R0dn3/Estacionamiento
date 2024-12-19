<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Salida de Vehículo</title>
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
            <span>Jueves, 5 de diciembre del 2024</span>
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

        <main class="content">
            <div class="form-container">
                <h1>Salida de Vehículo</h1>

                <!-- Formulario para buscar vehículo -->
                <form action="SalidaServlet" method="post">
                    <div class="form-row">
                        <label for="placa">Buscar por Placa:</label>
                        <input type="text" id="placa" name="placa" placeholder="Ingrese la placa" required>
                        <button type="submit">Buscar Vehículo</button>
                    </div>
                </form>

                <hr>

                <!-- Mostrar error si no se encontró el vehículo -->
                <c:if test="${not empty error}">
                    <p style="color: red;">${error}</p>
                </c:if>

                <!-- Mostrar datos del vehículo -->
                <c:if test="${not empty salida}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Placa</th>
                                <th>Clase de Vehículo</th>
                                <th>Fecha y Hora de Ingreso</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${salida.placa}</td>
                                <td>${salida.claseVehiculo}</td>
                                <td>${salida.fechaIngreso}</td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </main>
    </div>
</body>
</html>


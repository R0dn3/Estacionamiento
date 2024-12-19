<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Historial</title>
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
            <span>${pageContext.request.contextPath}Fecha actual</span>
        </div>
    </header>

    <div class="container">
        <nav class="sidebar">
            <ul>
                <li><a href="dashboard.jsp">INICIO</a></li>
                <li><a href="tarifa.jsp">TARIFAS</a></li>
                <li><a href="ingresos.jsp">INGRESOS</a></li>
                <li><a href="salida.jsp">SALIDA</a></li>
                <li><a href="historial.jsp" class="active">HISTORIAL</a></li>
            </ul>
        </nav>

        <main class="content">
            <h1>Historial de Ingresos</h1>

            <!-- Formulario de búsqueda -->
            <form action="HistorialServlet" method="get">
                <label for="placa">Filtrar por placa:</label>
                <input type="text" id="placa" name="placa" placeholder="Ingrese la placa">
                <label for="claseVehiculo">Filtrar por tipo de vehículo:</label>
                <input type="text" id="claseVehiculo" name="claseVehiculo" placeholder="Ej. Auto, Camioneta">
                <button type="submit">Buscar</button>
            </form>

            <hr>

            <!-- Mostrar historial -->
            <c:if test="${not empty historial}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Placa</th>
                            <th>Tipo de Vehículo</th>
                            <th>Fecha de Ingreso</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${historial}">
                            <tr>
                                <td>${item.placa}</td>
                                <td>${item.claseVehiculo}</td>
                                <td>${item.fechaIngreso}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <!-- Mostrar error si ocurre -->
            <c:if test="${not empty error}">
                <p style="color: red;">${error}</p>
            </c:if>
        </main>
    </div>
</body>
</html>

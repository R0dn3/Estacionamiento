<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar Pago</title>
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
        </div>
    </header>

    <div class="container">
        <nav class="sidebar">
            <ul>
                <li><a href="dashboard.jsp">INICIO</a></li>
                <li><a href="tarifa.jsp">TARIFAS</a></li>
                <li><a href="Ingresos.jsp">INGRESOS</a></li>
                <li><a href="salida.jsp">SALIDA</a></li>
                <li><a href="pago.jsp">PAGOS</a></li>
                <li><a href="historial.jsp">REPORTES</a></li>
            </ul>
        </nav>

        <main class="content">
            <div class="form-container">
                <form action="RegistrarPagoServlet" method="post">
                    <div class="form-row">
                        <label for="placa">Placa:</label>
                        <input type="text" id="placa" name="placa" required>
                    </div>
                    <div class="form-row">
                        <label for="metodo_pago">Método de Pago:</label>
                        <select id="metodo_pago" name="metodo_pago" required>
                            <option value="Efectivo">Efectivo</option>
                            <option value="Tarjeta de Crédito">Tarjeta de Crédito</option>
                            <option value="Tarjeta de Débito">Tarjeta de Débito</option>
                        </select>
                    </div>
                    <button type="submit">Registrar Pago</button>
                </form>

                <c:if test="${not empty pago}">
                    <h3>Pago Registrado</h3>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Placa</th>
                                <th>Clase de Vehículo</th>
                                <th>Fecha y Hora de Ingreso</th>
                                <th>Fecha y Hora de Salida</th>
                                <th>Monto Total</th>
                                <th>Método de Pago</th>
                                <th>Fecha del Pago</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${pago.placa}</td>
                                <td>${pago.claseVehiculo}</td>
                                <td>${pago.fechaIngreso}</td>
                                <td>${pago.fechaSalida}</td>
                                <td>S/. ${pago.monto}</td>
                                <td>${pago.metodoPago}</td>
                                <td>${pago.fechaPago}</td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>

                <c:if test="${not empty error}">
                    <p style="color: red;">${error}</p>
                </c:if>
            </div>
        </main>
    </div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Control</title>
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
                <li><a href=tarifa.jsp>TARIFAS</a></li>
                <li><a href="Ingresos.jsp">INGRESOS</a></li>
                <li><a href="salida.jsp">SALIDA</a></li>
                <li><a href="caja.jsp">CAJA</a></li>
                <li><a href="historial.jsp">REPORTES</a></li>
            </ul>
        </nav>

        <main>
            <div class="dashboard">
                <div class="card">
                    <div class="card-icon">🚗</div>
                    <div class="card-title">VEHÍCULOS ESTACIONADOS HOY</div>
                    <div class="card-number">1</div>
                </div>
                <div class="card">
                    <div class="card-icon">⏳</div>
                    <div class="card-title">TARIFAS</div>
                    <div class="card-number">1</div>
                </div>
                <div class="card">
                    <div class="card-icon">💲</div>
                    <div class="card-title">DINERO EN CAJA</div>
                    <div class="card-number">820.00</div>
                </div>
                <div class="card">
                    <div class="card-icon">👥</div>
                    <div class="card-title">ABONADOS</div>
                    <div class="card-number">1</div>
                </div>
            </div>
        </main>
    </div>
</body>
</html>

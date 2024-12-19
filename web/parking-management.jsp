<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ingreso de Vehículos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
    <script>
        // Función para cambiar el color del espacio de estacionamiento
        function toggleParkingSpot(spot) {
            if (spot.classList.contains('disponible')) {
                spot.classList.remove('disponible');
                spot.classList.add('ocupado');
            } else {
                spot.classList.remove('ocupado');
                spot.classList.add('disponible');
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>INGRESO DE VEHÍCULOS</h1>
        <form action="register-vehicle.jsp" method="POST">
            <div class="vehicle-info">
                <p><strong>NOMBRE DEL PROPIETARIO:</strong> <%= request.getAttribute("nombrePropietario") != null ? request.getAttribute("nombrePropietario") : "Juan Perez" %></p>
                <p><strong>PLACA:</strong> <%= request.getAttribute("placa") != null ? request.getAttribute("placa") : "ASW-555" %></p>
                <p><strong>TIPO DE VEHÍCULO:</strong></p>
                <label><input type="radio" name="tipo" value="carro" checked> Carro</label>
                <label><input type="radio" name="tipo" value="moto"> Moto</label>
            </div>

            <div class="parking-lots">
                <%
                    // Simulación de espacios de parqueo
                    String[] espacios = {"P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", 
                                         "P11", "P12", "P13", "P14", "P15", "P16", "P17", "P18", "P19", "P20",
                                         "P21", "P22", "P23", "P24", "P25", "P26", "P27", "P28"};
                    String[] estados = {"ocupado", "disponible", "disponible", "disponible", "disponible", "disponible", 
                                        "disponible", "disponible", "ocupado", "ocupado", 
                                        "disponible", "disponible", "disponible", "disponible", "disponible", 
                                        "disponible", "disponible", "disponible", "disponible", "disponible", 
                                        "disponible", "ocupado", "disponible", "disponible", "disponible", 
                                        "disponible", "disponible", "disponible"};
                    for (int i = 0; i < espacios.length; i++) {
                %>
                    <!-- Cada espacio de estacionamiento tiene un evento onclick para cambiar su estado -->
                    <div class="parking-space <%= estados[i] %>" onclick="toggleParkingSpot(this)"><%= espacios[i] %></div>
                <%
                    }
                %>
            </div>

            <div class="status">
                <span class="status-ocupado">OCUPADO</span>
                <span class="status-disponible">DISPONIBLE</span>
            </div>
        </form>
    </div>
</body>
</html>


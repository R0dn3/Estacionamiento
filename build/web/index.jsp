<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">

</head>
<body>
    <div class="container">
        <h1>¡Bienvenido!</h1>
        <div class="login-options">
            <div class="option">
                <img src="admin-icon.png" alt="Admin Icon">
                <a href="admin-login.jsp">
                    <button>Administrador</button>
                </a>
            </div>
            <div class="option">
                <img src="client-icon.png" alt="Empleado Icon">
                <a href="parking-management.jsp">
                    <button>Parqueos</button>
                </a>
            </div>
        </div>
    </div>
</body>
</html>


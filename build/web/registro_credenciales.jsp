<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Credenciales</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dashboard.css">
</head>
<body>
    <h1>Registro de Credenciales</h1>
    
    <!-- Formulario para registrar nuevas credenciales -->
    <form action="RegistrarCredencialesServlet" method="post">
        <div>
            <label for="username">Nombre de Credenciales:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Contraseña:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <button type="submit">Registrar Credenciales</button>
        </div>
    </form>
</body>
</html>

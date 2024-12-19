<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recuperación de Contraseña</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recuperacion_contrasena.css">
</head>
<body>
    <div class="form-container">
        <h2>Has olvidado tu contraseña</h2>
        
        <!-- Formulario de solicitud de nueva contraseña -->
        <div class="email-container">
            <label for="email">Correo electrónico:</label>
            <input type="email" id="email" name="email">
            <button type="submit" class="btn">Obtener nueva contraseña</button>
        </div>
        
        <!-- Formulario de nueva contraseña -->
        <div class="password-container">
            <label for="new-password">Contraseña:</label>
            <input type="password" id="new-password" name="new-password">
            <p class="password-hint">Elija una contraseña de al menos 6 caracteres.</p>
            <div class="password-strength">
                <p>Contraseña segura: <span id="password-status">Demasiado corta</span></p>
                <progress id="password-progress" value="0" max="100"></progress>
            </div>
        </div>
    </div>

    <!-- Aquí iría el código JavaScript para manejar la barra de progreso de la contraseña -->
    <script src="${pageContext.request.contextPath}/password_strength.js"></script>
</body>
</html>


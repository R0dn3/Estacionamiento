<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrarse</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/registro.css">
</head>
<body>
    <div class="form-container">
        <h2>Regístrate</h2>
        <form action="procesarRegistro" method="post">
            <div class="form-group">
                <label for="nombre">* Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="email">* Correo electrónico:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">* Contraseña:</label>
                <input type="password" id="password" name="password" required>
                <span class="tooltip">?</span>
            </div>
            <div class="form-group">
                <label for="confirmPassword">* Confirmar contraseña:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>
            <div class="form-group">
                <input type="checkbox" id="terms" name="terms" required>
                <label for="terms">Acepto los <a href="#">Términos de uso</a> y la <a href="#">Política de privacidad</a>.</label>
            </div>
            <div class="form-group">
                <button type="submit" class="btn-register">Registrar</button>
                <a href="#" class="more-info">Más información</a>
            </div>
        </form>

        <div class="social-register">
            <p>Regístrate usando tu cuenta con</p>
            <button class="btn-facebook">f Facebook</button>
            <button class="btn-google">G Google</button>
        </div>
    </div>
</body>
</html>


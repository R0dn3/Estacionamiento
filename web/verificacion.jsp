<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verificación</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/verificacion.css">
</head>
<body>
    <div class="form-container">
        <h2>Verificación</h2>
        <p>Mantenga esta ventana abierta y revise su correo electrónico</p>
        <p class="message">Te enviamos un código de 6 dígitos a tu dirección de correo electrónico. Verifica tu cuenta pegando el código a continuación. Asegúrate de revisar tu carpeta de correo no deseado.</p>

        <form action="verificarCodigo" method="POST">
            <div class="code-inputs">
                <input type="text" maxlength="1">
                <input type="text" maxlength="1">
                <input type="text" maxlength="1">
                <input type="text" maxlength="1">
                <input type="text" maxlength="1">
                <input type="text" maxlength="1">
            </div>

            <div class="actions">
                <p class="help-text">¿No recibiste el correo electrónico? <a href="#">Vuelve a enviar el código</a> o <a href="#">verifica tu dirección de correo electrónico</a>.</p>
                <p class="help-text">Si aún necesitas ayuda, envía un correo electrónico a <a href="mailto:support@gmail.com">support@gmail.com</a>.</p>
                <button type="submit" class="btn-acceder">Acceder</button>
            </div>
        </form>
    </div>
</body>
</html>


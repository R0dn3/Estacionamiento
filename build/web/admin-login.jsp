<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ingreso Administrador</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <h1>¡Bienvenido!</h1>
        
        <!-- Formulario de login que apunta al Servlet -->
        <form action="AdminLoginServlet" method="POST">
            <div class="admin-login">
                <input type="password" name="adminPassword" placeholder="********" class="password" required>
                <div class="numeric-pad">
                    <button type="button" onclick="addNumber(1)">1</button>
                    <button type="button" onclick="addNumber(2)">2</button>
                    <button type="button" onclick="addNumber(3)">3</button>
                    <button type="button" onclick="addNumber(4)">4</button>
                    <button type="button" onclick="addNumber(5)">5</button>
                    <button type="button" onclick="addNumber(6)">6</button>
                    <button type="button" onclick="addNumber(7)">7</button>
                    <button type="button" onclick="addNumber(8)">8</button>
                    <button type="button" onclick="addNumber(9)">9</button>
                    <button type="button" onclick="addNumber(0)">0</button>
                </div>
                <button type="submit">Ingresar</button>
            </div>
        </form>

        <!-- Mostrar mensaje de error si la contraseña es incorrecta -->
        <c:if test="${not empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>
    </div>

    <script>
        function addNumber(num) {
            var passField = document.querySelector('.password');
            passField.value += num;
        }
    </script>
</body>
</html>

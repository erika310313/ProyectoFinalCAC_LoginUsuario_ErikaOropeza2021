<%-- 
    Document   : login
    Created on : 07/08/2021, 08:46:44 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <link rel="stylesheet" href="css/estilosLogin.css" type="text/css" media="all">
        
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //Borrar directivas de memoria cache y anular algoritmos predeterminados para almacenar cache
            response.setHeader("Pragma", "no-cache"); //Directivas compatibles con memorias cache
            response.setDateHeader("Expires", 0); //Proporciona fecha y hora para decir el tiempo de respuesta caduco
        %>
    </head>
    <body>
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form class="formularioLogin" id="formularioLogin" method="post" action="IniciarSesionServlet">
                <img class="mb-4" src="imagen/Logo Sabores Venearg (1).png" alt="" width="200" height="200">
                
                <h1>Iniciar Sesión</h1>
            
                <p>Usuario: </p>
                <div class="texto" >
                    <input type="text" class="txt" id="txtUsuario" required="" name="txtUsuario">
                </div>

                <p>Contraseña: </p>
                <div class="texto" >
                    <input type="Password" class="txt" id="txtContrasenia" required="" name="txtContrasenia">
                </div>

                <br>

                <input type="submit" value="Iniciar Sesión" class="btn">
                <input type="submit" value="Borrar Datos" class="btn" onclick="resetearFormularioLogin()">
            </form>
        </div>
        
        
    </body>
    
    <script src="js/funcionesLoginUsuario.js"></script>
    
    
</html>

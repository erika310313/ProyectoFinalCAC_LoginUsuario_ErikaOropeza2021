<%-- 
    Document   : registroUsuario
    Created on : 07/08/2021, 08:47:03 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuario</title>
        
        <link rel="stylesheet" href="css/estilosRegistroUsuario.css"/>
        
                <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
            response.setHeader("Pragma", "no-cache"); 
            response.setDateHeader("Expires", 0); 
        %>
    </head>
    <body>
        
        <div class="cuerpoFormulario" id="cuerpoFormulario">
            <form class="formularioRegistro" id="formularioRegistro" method="post" action="GuardarServlet">
                <img class="mb-4" src="imagen/Logo Sabores Venearg (1).png" alt="" width="200" height="200">
                
                <h1>Registro de Usuario</h1>
                <br>
                <label>Usuario: </label><input type="text" class="txt" id="txtUsuario" required="" name="txtUsuario">
                <br>
                <br>
                <label>Nombre: </label><input type="text" class="txt" id="txtNombre" required="" name="txtNombre">
                <label>Apellido: </label><input type="text" class="txt" id="txtApellido" required="" name="txtApellido">
                <br>
                <br>
                <label>Documento: </label><input type="text" class="txt" id="txtDocumento" required="" name="txtDocumento">

                <label>Correo Electrónico: </label><input type="text" class="txt" id="txtEmail" required="" name="txtEmail">
                <br>
                <br>
                <label>Contraseña: </label><input type="password" class="txt" id="txtContrasenia" required="" onkeyup="coincidirContrasenia()">
                <label>Repite la contraseña: </label><input type="password" class="txt" id="txtRepetirContrasenia" required="" onkeyup="coincidirContrasenia()" name="txtContrasenia">
                <br>
                <br>
                <label class="avisoContrasenia" id="avisoContrasenia"> ------------------ </label>
                <br>
                <br>
                
                <input type="submit" value="Enviar Datos" class="btn" id="btnEnviarDatos" disabled="">
                <input type="button" value="Borrar Datos" class="btn" id="btnBorrar" onclick="resetearFormularioRegistro()">

            </form>
        </div>
        
        
        
      
    </body>
    
    <script src="js/funcionesRegistroUsuario.js"></script>
    
</html>

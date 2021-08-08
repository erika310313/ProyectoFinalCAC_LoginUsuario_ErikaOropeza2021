<%-- 
    Document   : paginaInicio
    Created on : 08/08/2021, 04:40:34 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Pedido</title>
        
        
        
           
            <style>
                .bd-placeholder-img {
                  font-size: 1.125rem;
                  text-anchor: middle;
                  -webkit-user-select: none;
                  -moz-user-select: none;
                  -ms-user-select: none;
                  user-select: none;
                }

                @media (min-width: 768px) {
                  .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                  }
                }
            </style>
            
        <link rel="stylesheet" href="css/estilosPaginaInicio.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/estilosPedidosCAC.css" type="text/css" media="all">
        
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            if (session.getAttribute("txtUsuario") == null && session.getAttribute("nombre") == null) {
                response.sendRedirect("index.html");
            }
        %>
        
    </head>
    <body class="bg-light">
        
        <h1>Hola <%=request.getSession().getAttribute("nombre")%>, ¡BIENVENIDO/A! </h1>
        
        <div class="contenidoInicio">
            
            
            
            <div class="py-5 text-center">
                <img class="d-block mx-auto mb-4" src="imagen/Logo Sabores Venearg (1).png" alt="" width="200" height="200">
                <h1>Formulario de Pedido</h1>
                <p class="lead">La fecha de entrega será coordinada telefónicamente.</p>
            </div>


            
                <h4 class="mb-3">Tu pedido</h4>
                <form class="needs-validation" novalidate>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="firstName">Nombre</label>
                            <input type="text" class="form-control" id="firstName" placeholder="Tu nombre" value="" required>
                            <div class="invalid-feedback">
                                Faltó ingresar el nombre.
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="lastName">Apellido</label>
                            <input type="text" class="form-control" id="lastName" placeholder="Tu apellido" value="" required>
                            <div class="invalid-feedback">
                                Faltó ingresar el apellido.
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="username">Nombre de Usuario</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">@</span>
                            </div>
                            <input type="text" class="form-control" id="username" placeholder="Usuario" required>
                            <div class="invalid-feedback" style="width: 100%;">
                                Faltó ingresar el usuario.
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="email">Email <span class="text-muted">(Optional)</span></label>
                        <input type="email" class="form-control" id="email" placeholder="tumail@gmail.com">
                        <div class="invalid-feedback">
                            El Email parece inválido.
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="address">Lugar de Entrega</label>
                        <input type="text" class="form-control" id="address" placeholder="Calle, n°, localidad..." required>
                        <div class="invalid-feedback">
                            Faltó ingresar el domicilio de entrega.
                        </div>
                    </div>



                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="country">Localidad</label>
                            <select class="custom-select d-block w-100" id="country" required>
                                <option value="">Seleccioná...</option>
                                <option>Moreno</option>
                            </select>
                            <div class="invalid-feedback">
                                Seleccioná una localidad válida.
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="state">Provincia</label>
                            <select class="custom-select d-block w-100" id="state" required>
                                <option value="">Seleccioná...</option>
                                <option>Buenos Aires</option>
                                <option>Tucumán</option>			  
                            </select>
                            <div class="invalid-feedback">
                                Seleccioná una provincia válida.
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="zip">Cod.Postal</label>
                            <input type="text" class="form-control" id="zip" placeholder="" required>
                            <div class="invalid-feedback">
                                Faltó ingresar el Código Postal.
                            </div>
                        </div>
                    </div>


                    <hr class="mb-6">

                    <h4 class="mb-3">Forma de Pago</h4>

                    <div class="d-block my-3">
                        <div class="custom-control custom-radio">
                            <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked required>
                            <label class="custom-control-label" for="credit">Tarjeta de Crédito</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input id="debit" name="paymentMethod" type="radio" class="custom-control-input" required>
                            <label class="custom-control-label" for="debit">Mercado Pago</label>
                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="cc-name">Nombre del Titular de la Tarjeta</label>
                            <input type="text" class="form-control" id="cc-name" placeholder="" required>
                            <small class="text-muted">Nombre como se muestra en la tarjeta</small>
                            <div class="invalid-feedback">
                                El nombre debe ser ingresado.
                            </div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="cc-number">Número de la tarjeta</label>
                            <input type="text" class="form-control" id="cc-number" placeholder="" required>
                            <div class="invalid-feedback">
                                El n° es obligatorio. 
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 mb-3"></div>
                        <div class="col-md-3 mb-3">
                            <label for="cc-expiration">Fecha de Vto.</label>
                            <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
                            <div class="invalid-feedback">
                                Falta ingresar la fecha de Vto.
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <label for="cc-cvv">Código</label>
                            <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                            <div class="invalid-feedback">
                                N° de seguridad obligatorio.
                            </div>
                        </div>
                    </div>
                    <hr class="mb-4">	
                    <div class="row">
                        <div class="col-4"></div>				
                        <div class="col-4">
                            <input type="submit" class="btn" name="submit" value="Ingresar la Solicitud" >
                            
                            
                        </div>

                    </div>
                </form>
            
        </div>
        
        <form action="CerrarSesionServlet">
            <input type="submit" class="btn" value="Cerrar Seción">
        </form>
        

        
        <footer class="my-5 pt-5 text-muted text-center text-small">
            <p class="mb-1">Copyright &copy; 2021 Erika Oropeza</p>
        </footer>
            
      
    </body>
</html>

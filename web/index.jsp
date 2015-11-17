<%-- 
    Document   : indez
    Created on : Nov 12, 2015, 9:05:41 PM
    Author     : Adri
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
         <script src="js/jquery-ui.js"></script>
         <link rel="stylesheet" href="css/jquery-ui.css">
        <script type="text/javascript" src="js/JQIndex.js"></script>
        <script type="text/javascript" src="js/JsIndex.js"></script>

<script src="jquery.ui.datepicker-es.js"></script>

        <title>Login</title>
    </head>
    <body>
        <div id="loginForm">
            <h1>Login</h1>
            <form action="Validar.jsp" method="post">
            <input type="email"  placeholder="Correo Usuario"  id="usu" name="user" class = "txt" required/>
            <input type="password" id="pass" name="contra" placeholder="Contraseña" required>
            <button type="submit" ><i class="fa fa-arrow-right"></i></button>
            <a id="Reg">Registrarse</a>
            </form>
        </div>
        <div class="registro" id="formu2">
            <h1>Registro</h1>
            <form action="registrar.jsp" method="post" onsubmit="return validaFormu()">
                <div class="columna">
                <table>
      <tr>
          <td>Nombre:<input type="text" id="nombre" name="nombre" class="txt" onkeydown="return validarLetras(event)" required=""/></td>
                </tr>
                <tr>
                    <td>Apellido:<input type="text" id="apel" name="apellido" class="txt" onkeydown="return validarLetras(event)" required/></td>
                </tr>
                <tr>
                    <td>Correo Eletro&oacute;nico:<input type="text" id="correo" name="correo"  class="txt" required /></td>
                </tr>
                <tr>
                    <td>
                        Fecha de nacimiento:
                        <input type="text" id="fechaNac" name="fecha"  required class="txt" />
                    </td>  
                </tr>
                </table>
                </div>
                
                <div class="columna">
                    <table>
                        
                     
                   <tr>
                    <td>Contrase&ntilde;a:<input type="password" id="pass1" name="pass" class="txt" required/></td>
                </tr>
                <tr>
                    <td>Confirmar contrase&ntilde;a:<input type="password" id="pass2" name="pass2" class="txt" required/></td>
                </tr>
                <tr>
                    <td>G&eacute;nero:<br>
                        <span class="p">M</span><input type="radio" name="sexo" value="Masculino" checked />
                        F<input type="radio" name="sexo" value="Femenino" />
                      
                    </td>
                </tr>  
                    </table>         
                </div>
                <button id="btn"><i class="fa fa-check"></i></button>
            </form>
        </div>
    </body>
</html>

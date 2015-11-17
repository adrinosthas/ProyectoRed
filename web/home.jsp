<%-- 
    Document   : home
    Created on : Nov 16, 2015, 10:46:02 AM
    Author     : Adri
--%>
<%@page import="datos.Usuario"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>

         <link rel="stylesheet" type="text/css" href="css/stylehome.css">
	
</head>
<body>
      <%
            Usuario usu=new Usuario();
            usu = (Usuario) session.getAttribute("user");
            out.print("holi");
         %>
	

                    <ul class="menu">
                        <li class="opc"><a href="perfil.jsp?id=<%=usu.getIdUsuario()%>">Perfil</a></li>
                        <li class="opc"><a href="#">Mensajes</a></li>
                        <li class="opc"><a href="#">Notificaciones</a></li>
                        <li class="opc"><a href="#">Solicitudes Amistad</a></li>
                        <li class="opc"><a href="#">Eventos</a></li>
                        <li class="opc"><a href="#">Cerrar Sesion</a></li>
                    </ul>

        <input type="checkbox" id="boton1" class="boton1" />
        <label for="boton1"></label>

<div class="dPrincipal">
    
 HOLIIIIIIIIIIIIIIIIIIIIIIIII AQUI VA EL HOMEEEE YUPIIIIIIIII 
</div>


</body>
</html>



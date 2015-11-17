<%-- 
    Document   : perfil
    Created on : 11-15-2015, 03:28:24 PM
    Author     : Usuario
--%>

<%@page import="datos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAOS.DAOUsuario"%>
<%--<%@page import="DAOS.DAOFoto"%>--%>
<%@page import="datos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/CSSperfil.css">
         <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/perfil.js"></script>
    </head>
    <body>
        <%
            Usuario usi =new Usuario();
            usi=(Usuario)session.getAttribute("user");
           // DAOFoto dfoto = new DAOFoto();
        %>
        <div id="contenedor">
            <br/><br/><br/>
            <%
                DAOUsuario du=new DAOUsuario();
                ArrayList tabla = du.getUsuario(Integer.parseInt(request.getParameter("id")));
                for(Object fila:tabla){
                        String nombre=((ArrayList) fila).get(0).toString();
                        String apellido=((ArrayList) fila).get(1).toString();
                        out.print("<br/><center><h1>"+nombre+" "+apellido+"</h1></center><br/>");
                }
            %>
            <div id="foto">
                
            </div>
            <br/>
            <%
            if(usi.getIdUsuario() == Integer.parseInt(request.getParameter("id"))){
            %>
            <div id="bloque">
                <div id="nav">
                    <ul class="nav">
                        <li class="nivel2"><a href="#muro" onclick="cargar('#muro', 'jspPerfil/muro.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>')" class="nivel2">Muro</a></li>
                        <li class="nivel2"><a href="#album" onclick="cargar('#album', 'jspPerfil/album.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>')" class="nivel2">&Aacute;lbum</a></li>
                        <li class="nivel2"><a href="#eventos" onclick="cargar('#eventos', 'jspPerfil/evento.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>')" class="nivel2">Eventos</a></li>
                        <li class="nivel2"><a href="#amigos" onclick="cargar('#amigos', 'jspPerfil/amigos.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>')" class="nivel2">Amigos</a></li>
                        <li class="nivel2"><a href="#info" onclick="cargar('#info', 'jspPerfil/infoPersonal.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>')" class="nivel2">Informaci&oacute;n Personal</a></li>
                    </ul>
                    <!-- -->
                </div>
                <div id="opciones">
                    <div id="muro" class="opciones"></div>
                    <div id="album" class="opciones"></div>
                    <div id="eventos" class="opciones"></div>
                    <div id="amigos" class="opciones"></div>
                    <div id="info" class="opciones"></div>
                </div>
            </div>
             <%}%>
            
        </div>
           
    </body>
</html>

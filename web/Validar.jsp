<%-- 
    Document   : Validar
    Created on : Nov 12, 2015, 9:29:58 PM
    Author     : Adri
--%>

<%@page import="datos.Usuario"%>
<%@page import="DAOS.DAOUsuario"%>
<%@page import="DAOS.DAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="datos.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% try{
            String correo=request.getParameter("user");
           String contra=request.getParameter("contra");
           String[] arr= new String[4];
           DAO dao= new DAO();
           User usi= new User();
           usi.setCorreo(correo);
           usi.setContra(contra);
           arr=DAO.getUserMen(usi);
           
           if(arr[0]!=null){
               if(arr[0].equals(correo)&& arr[1].equals(contra)){
                   out.print("Bienvenido/a "+arr[2]+ "<br>");
                         Usuario usu=new Usuario();
                   
                   usu.setIdUsuario(dao.getIdUsuario(correo));
                   session.setAttribute("user", usu);
                    response.setHeader("Refresh",";home.jsp");
               %>         
               
               <%
               }else{
                   out.print("Contraseña incorrecta");
                   session.invalidate();
               }
           }else{
               out.print("No se encontr&oacute; el usuario con el correo ingresado");
               session.invalidate();
           }
           
        }catch(SQLException ex){
            out.print("Error Base de Datos");
            out.print(ex.getMessage());
        }
        %>
    </body>
</html>

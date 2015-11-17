
<!--    Document   : registro
    Created on : Nov 15, 2015, 3:52:03 PM
    Author     : ytAdri-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="java.sql.SQLException"%>
<%@page import="DAOS.*"%>
<%@page import="datos.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-image:url(fondo1.jpg);
            }
        </style>
    </head>
    <body>
        <% 
              try{
            DAO dao=new DAO();
            
        if(dao.ExisteU(request.getParameter("correo"))){
                  out.print("<h1><center>");
            out.print("CORREO YA EXISTE");
            out.print("</center></h1>");
            response.setHeader("Refresh", "2;index.jsp");
        
        }else{
                
                 String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String correo=request.getParameter("correo");       
        
        String pass=request.getParameter("pass");
        String fechaNac=request.getParameter("fecha");
        String genero=request.getParameter("sexo");
        User user=new User();
        DAO dusu=new DAO();
        FOTO foto=new FOTO();
        DAOFOTO dFot=new DAOFOTO();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setCorreo(correo);
        user.setContra(pass);
        user.setFechaNac(fechaNac);
        user.setGenero(genero);
        user.setUsuarioActivo(true);
         dusu.insertUsuario(user);
       out.print("USUARIO REGISTRADO EXITOSAMENTE");
       out.print(correo);
        String url=getServletContext().getRealPath("/")+"/perfiles/"+correo;
        File direc=new File(url);
        direc.mkdirs();
        int idUsuario = dusu.getIdUsuario(correo);
          ALBUM album=new ALBUM();      
        album.setIdUsuario(idUsuario);
        album.setNombreAlbum("FOTOS PERFIL"); 
        album.setUrlAlbum("null");
    DAOALBUM al=new DAOALBUM();
     al.insertAlbum(album);
       out.print("<br>"+al.getIdLastAlbum(idUsuario));
          String urlAlbum=getServletContext().getRealPath("/")+"/perfiles/"+correo+"/"+al.getIdLastAlbum(idUsuario);
             File nAlbum=new File(urlAlbum);
        if(nAlbum.mkdirs()){
            out.print("<br>ALBUM CREADO YUPIIII <br>");
        }else{
            out.print("<br>NO SE CREO ALBUM, FOTO PERFIL NOOO :( <br>");
        }
        al.updateURLalbum(al.getIdLastAlbum(idUsuario), urlAlbum);
       
        foto.setIdUsuario(idUsuario);
        foto.setIdAlbum(al.getIdLastAlbum(idUsuario));
        foto.setUrlFoto("imagenes/persona.png");
        foto.setFotoPerfil(true);
        dFot.insertF(foto);
             
         response.setHeader("Refresh","2;index.jsp");
        
        }
 
        }catch(SQLException ex){
                out.print("HA OCURRIDO UN ERROR INESPERADO");
        out.print(ex.getMessage());
        response.setHeader("Refresh","1;index.jsp");
        }      
        %>
    </body>
</html>

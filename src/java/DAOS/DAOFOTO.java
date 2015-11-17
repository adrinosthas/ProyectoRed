/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import datos.FOTO;
/**
 *
 * @author Adri
 */
public class DAOFOTO {
     public void insertF(FOTO foto) throws ParseException, ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String queryInsert="INSERT INTO FOTO VALUES(null,?,?,now(),?,?)";
        PreparedStatement ps=cnx.prepareStatement(queryInsert);
        ps.setInt(1, foto.getIdAlbum());
        ps.setInt(2, foto.getIdUsuario());
        ps.setBoolean(3, foto.isFotoPerfil());
        ps.setString(4, foto.getUrlFoto());
        ps.executeUpdate();
        cnx.close();
    }
    public void borrarF(int idFoto) throws ClassNotFoundException, SQLException{
        Connection cnx= Conexion.cnx();
        String queryDelete="DELETE FROM FOTO WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(queryDelete);
        ps.setInt(1, idFoto);
        ps.executeUpdate();
        cnx.close();
    }
    
    public boolean fperfil(int idFoto) throws ClassNotFoundException,SQLException{
        Connection cnx=Conexion.cnx();
        boolean flag;
        String query="SELECT perfil FROM FOTO WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idFoto);
        ResultSet rs=ps.executeQuery();
        rs.next();
        if(rs.getBoolean("perfil")){
            flag=true;
        }else{
            flag=false;
        }
        cnx.close();
        return flag;
    }
    
    public ArrayList getAllFotoxAlbum(int idAlbum) throws ClassNotFoundException, SQLException{
        ArrayList row;
        ArrayList reg=new ArrayList();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM FOTO WHERE idAlbum=?";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ps.setInt(1, idAlbum);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            row=new ArrayList();
            row.add(rs.getInt("idFoto"));
            row.add(rs.getString("urlFoto"));
            reg.add(row);
        }
        cnx.close();
        return reg;
    }
    
    public FOTO getInfoFoto(int idFoto) throws ClassNotFoundException, SQLException{
       FOTO pic=new FOTO();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM FOTO WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ps.setInt(1, idFoto);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            pic.setIdFoto(rs.getInt("idFoto"));
            pic.setIdAlbum(rs.getInt("idAlbum"));
           pic.setIdUsuario(rs.getInt("idPersona"));
            pic.setUrlFoto(rs.getString("urlFoto"));
            pic.setFechaPublicada(rs.getString("fechaSubida"));
        }
        cnx.close();
        return pic;
    }
    
    public void cambiarFotoPerfil(FOTO foto) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String query="UPDATE FOTO SET perfil=? WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setBoolean(1, foto.isFotoPerfil());
        ps.setInt(2, foto.getIdFoto());
        ps.executeUpdate();
        cnx.close();
    }
    
    public int getFotoPerfil(int idUser) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        int id=0;
        String query="SELECT idFoto FROM FOTO WHERE perfil=? AND idUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setBoolean(1, true);
        ps.setInt(2, idUser);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            id=rs.getInt("idFoto");
        }
        cnx.close();
        return id;
    }
    
    public String getRutaFotoPerfil(int idUser) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String ruta="";
        int id=getFotoPerfil(idUser);
        String query="SELECT urlFoto FROM FOTO WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            ruta=rs.getString("urlFoto");
        }
        cnx.close();
        return ruta;
    }
        public String getRutaFoto(int idFoto) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String ruta="";
        //int id=getFotoPerfil();
        String query="SELECT urlFoto FROM FOTO WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idFoto);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            ruta=rs.getString("urlFoto");
        }
        cnx.close();
        return ruta;
    }
        public boolean isUCreadorFoto(int idFoto,int idUsuario) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        boolean flag;
        String query="SELECT idFoto FROM FOTO WHERE (idFoto=? AND idUsuario=?)";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idFoto);
        ps.setInt(2, idUsuario);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            flag=true;
        }else{
            flag=false;
        }
        cnx.close();
        return flag;
    }
        public int getCreadorFoto(int idFoto) throws ClassNotFoundException, SQLException{
            Connection cnx=Conexion.cnx();
            int id=0;
            String query="SELECT idUsuario FROM FOTO WHERE idFoto=?";
            PreparedStatement ps=cnx.prepareStatement(query);
            ps.setInt(1, idFoto);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                id=rs.getInt("idUsuario");
            }
            cnx.close();
            return id;
        }
        
          public int getIdLastFoto(int idUsuario)throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        int id=0;
        String query="SELECT idFoto FROM FOTO WHERE idUsuario=? ORDER BY fechaSubida DESC LIMIT 1";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idUsuario);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            id=rs.getInt("idFoto");
        }
        cnx.close();
        return id;
    }
              
    public void updateURLFoto(int idFoto, String url) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String query="UPDATE FOTO SET urlFoto=? WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setString(1, url);
        ps.setInt(2, idFoto);
        ps.executeUpdate();
        cnx.close();
    }
      public String getTimeDiff(int idFoto) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String tiempo="";
        String query="SELECT TIME_TO_SEC(TIMEDIFF(now(), fechaSubida)) as tiempo FROM FOTO WHERE idFoto=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idFoto);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            tiempo=rs.getString("tiempo");
        }
        cnx.close();
        return tiempo;
    }
}

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
import datos.ALBUM;
/**
 *
 * @author Adri
 */
public class DAOALBUM {
     public void insertAlbum(ALBUM album) throws ParseException, ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String queryInsert="INSERT INTO ALBUM VALUES(null,?,?,now(),?)";
        PreparedStatement ps=cnx.prepareStatement(queryInsert);
        ps.setInt(1, album.getIdUsuario());
        ps.setString(2, album.getNombreAlbum());
        ps.setString(3, album.getUrlAlbum());
        ps.executeUpdate();
        cnx.close();
    }
    
    public void updateURLalbum(int idAlbum, String url) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String query="UPDATE ALBUM SET urlAlbum=? WHERE idAlbum=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setString(1, url);
        ps.setInt(2, idAlbum);
        ps.executeUpdate();
        cnx.close();
    }
    
    public void deleteAlbum(int idAlbum) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String queryDelete="DELETE FROM ALBUM WHERE idAlbum=?";
        PreparedStatement ps=cnx.prepareStatement(queryDelete);
        ps.setInt(1, idAlbum);
        ps.executeUpdate();
        cnx.close();
    }
    public ArrayList getAllAlbum(int idUser) throws ClassNotFoundException, SQLException{
        ArrayList row;
        ArrayList reg=new ArrayList();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM ALBUM WHERE idUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ps.setInt(1, idUser);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            row=new ArrayList();
            row.add(rs.getInt("idAlbum"));
            row.add(rs.getString("nombreAlbum"));
   
            row.add(rs.getString("urlAlbum"));
            row.add(rs.getString("fechaCreacion"));
            reg.add(row);
        }
        cnx.close();
        return reg;
    }
    public ALBUM getInfoFoto(int idAlbum) throws ClassNotFoundException, SQLException{
       ALBUM alb=new ALBUM();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM ALBUM WHERE idAlbum=?";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ps.setInt(1, idAlbum);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            alb.setIdAlbum(rs.getInt("idAlbum"));
           alb.setIdUsuario(rs.getInt("idUsuario"));
            alb.setNombreAlbum(rs.getString("nombreAlbum"));
            alb.setFechaCreacion(rs.getString("fechaCreacion"));
        }
        cnx.close();
        return alb;
    }
    public boolean isUsuarioCreadorAlbum(int idAlbum,int idUsuario) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        boolean flag;
        String query="SELECT idAlbum FROM ALBUM WHERE idAlbum=? AND idUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idAlbum);
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
    
    public int getIdLastAlbum(int idUsuario)throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        int id=0;
        String query="SELECT idAlbum FROM ALBUM WHERE idUsuario=? ORDER BY fechaCreacion DESC LIMIT 1";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idUsuario);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            id=rs.getInt("idAlbum");
        }
        cnx.close();
        return id;
    }
    
     public int getIdMyPic(int idUsuario)throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        int id=0;
        String query="SELECT idAlbum FROM ALBUM WHERE idUsuario=? AND nombreAlbum like 'FOTOS PERFIL'";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setInt(1, idUsuario);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            id=rs.getInt("idAlbum");
        }
        cnx.close();
        return id;
     }
}

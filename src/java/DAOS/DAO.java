
  package DAOS;

import datos.User;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import properties.Property;
  import DAOS.Conexion;
import static java.lang.System.out;

/** @author Diego */
public class DAO {


     public static void insertUsuario(User user) throws ParseException, ClassNotFoundException, SQLException {

        Connection cnx = Conexion.cnx();

      String queryInsert="INSERT INTO USUARIO VALUES(null,?,?,?,?,?,?,now(),?)";
        PreparedStatement ps=cnx.prepareStatement(queryInsert);
        ps.setString(3,user.getCorreo());
        ps.setString(1,user.getNombre());
        ps.setString(2,user.getApellido());
        ps.setString(5,user.getGenero());
        ps.setString(4,user.getContra());
        ps.setString(6,user.getFechaNac());
        ps.setBoolean(7,user.isUsuarioActivo());
        ps.executeUpdate();
        cnx.close();
    }
    
    public static void modificarUsuario(User user) throws ParseException, ClassNotFoundException, SQLException{
      Connection cnx=Conexion.cnx();
      String queryUpdate="UPDATE USUARIO SET nombreUsuario=?,apellidoUsuario=?,generoUsuario=?, contraUsuario=?, fechaNacUsuario=? WHERE idUsuario=?";
      PreparedStatement ps=cnx.prepareStatement(queryUpdate);
      ps.setString(1, user.getNombre());
      ps.setString(2, user.getApellido());
      ps.setString(3,user.getGenero());
      ps.setString(4,user.getContra());
      ps.setString(5,user.getFechaNac());
      ps.setInt(6,user.getIdUsuario());
      ps.executeUpdate();
      cnx.close();
    }
    
    public void modificarActividadUsuario(User user) throws ParseException, ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String queryUpdate="UPDATE redSocial.usuario set isActivo=? WHERE idUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(queryUpdate);
        ps.setBoolean(1, user.isUsuarioActivo());
        ps.setInt(2, user.getIdUsuario());
        ps.executeUpdate();
        cnx.close();
    }
    
    public static ArrayList getUsuario(int idUser) throws ClassNotFoundException, SQLException{
        ArrayList row;
        ArrayList reg=new ArrayList();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM redSocial.usuario WHERE idUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ps.setInt(1, idUser);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            row=new ArrayList();
            row.add(rs.getString("nombreUsuario"));
            row.add(rs.getString("apellidoUsuario"));
            row.add(rs.getString("correoUsuario"));
            row.add(rs.getString("contraUsuario"));
            row.add(rs.getString("sexoUsuario"));
            row.add(rs.getString("fechaNaUsuario"));
            reg.add(row);
        }
        cnx.close();
        return reg;
    }
        public User getUsuario2(int idUser) throws ClassNotFoundException, SQLException{
        User user=new User();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM redSocial.usuario WHERE idUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ps.setInt(1, idUser);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            user.setIdUsuario(rs.getInt("idUsuario"));
            user.setCorreo(rs.getString("correoUsuario"));
            user.setNombre(rs.getString("nombreUsuario"));
            user.setApellido(rs.getString("apellidoUsuario"));
            user.setGenero(rs.getString("sexoUsuario"));
            user.setContra(rs.getString("contraUsuario"));
            user.setFechaNac(rs.getString("fechaNaUsuario"));
        }
        cnx.close();
        return user;
    }
        public static User getUsuarioName(int idUser) throws ClassNotFoundException, SQLException{
       User user=new User();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM redSocial.usuario WHERE idUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ps.setInt(1, idUser);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            user.setNombre(rs.getString("nombreUsuario"));
            user.setApellido(rs.getString("apellidoUsuario"));
        }
        cnx.close();
        return user;
    }
        public static ArrayList getAllUsuario() throws ClassNotFoundException, SQLException{
        ArrayList row;
        ArrayList reg=new ArrayList();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM redSocial.usuario";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            row=new ArrayList();
            row.add(rs.getString("correoUsuario"));
            row.add(rs.getString("nombreUsuario"));
            row.add(rs.getString("apellidoUsuario"));
            reg.add(row);
        }
        cnx.close();
        return reg;
    }
      public ArrayList getAllUsuario(String opc) throws ClassNotFoundException, SQLException{
        ArrayList row;
        ArrayList reg=new ArrayList();
        Connection cnx=Conexion.cnx();
        String querySelect="SELECT * FROM redSocial.usuario WHERE nombreUsuario LIKE '%"+opc+"%' OR apellidoUsuario LIKE '%"+opc+"%'";
        PreparedStatement ps=cnx.prepareStatement(querySelect);
      //  ps.setString(1, opc);
      //  ps.setString(2, opc);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            row=new ArrayList();
            row.add(rs.getString("correoUsuario"));
            row.add(rs.getString("nombreUsuario"));
            row.add(rs.getString("apellidoUsuario"));
            reg.add(row);
        }
        cnx.close();
        return reg;
    }

       public static boolean isUsuExist(String correo) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        boolean flag;
        String query="SELECT correoUsuario FROM USUARIO WHERE correoUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setString(1, correo);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            flag=true;
        }else{
            flag=false;
        }
        cnx.close();
        return flag;
    }
       
       public boolean isUserActivo(int idUser) throws ClassNotFoundException, SQLException{
           Connection cnx=Conexion.cnx();
           boolean flag;
           String query="SELECT isActivo FROM USUARIO WHERE idUsuario=?";
           PreparedStatement ps=cnx.prepareStatement(query);
           ps.setInt(1, idUser);
           ResultSet rs=ps.executeQuery();
           rs.next();
           if(rs.getBoolean("isActivo")){
               flag=true;
           }else{
               flag=false;
           }
           cnx.close();
           return flag;
       }
       
      public int getIdUsuario(String correoUser) throws ClassNotFoundException, SQLException{
          int id = 0;
         Connection cnx = Conexion.cnx();
  
             String query="SELECT idUsuario FROM USUARIO WHERE correoUsuario=?";
             PreparedStatement ps=cnx.prepareStatement(query);
             ps.setString(1, correoUser);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                 id=rs.getInt("idUsuario");
             }
      
           return id;
       }
       
       public String getContra(String correoUser)throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        String contra="";
        String query="SELECT contraUsuario FROM USUARIO WHERE correoUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setString(1, correoUser);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            contra=rs.getString("contraUsuario");
        }
        cnx.close();
        return contra;
    }
       
     public boolean isLoginOk(String correo, String contra) throws ClassNotFoundException, SQLException{
         //Connection cnx=CONEXION.cnx();
         boolean flag;
         String pass=getContra(correo);
         if(pass.equals(contra)){
             flag=true;
         }else{
             flag=false;
         }
         return flag;
     }
  
   

    public static String[] getUserMen(User correo) throws ClassNotFoundException, SQLException {
        String[] arr= new String[4];

        Connection cnx = Conexion.cnx();

        String querySelect = "SELECT correoUsuario, nombreUsuario, contraUsuario FROM redsocial.usuario  WHERE correoUsuario=?";
        PreparedStatement ps = cnx.prepareStatement(querySelect);
        ps.setString(1, correo.getCorreo());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            arr[1]=rs.getString("contraUsuario");
            arr[0]=rs.getString("correoUsuario");
                arr[2]=rs.getString("nombreUsuario");
        }

        cnx.close();
            return arr;
    }
   
    public static boolean ExisteU(String correo) throws ClassNotFoundException, SQLException{
        Connection cnx=Conexion.cnx();
        boolean flag;
        String query="SELECT correoUsuario FROM USUARIO WHERE correoUsuario=?";
        PreparedStatement ps=cnx.prepareStatement(query);
        ps.setString(1, correo);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            flag=true;
        }else{
            flag=false;
        }
        cnx.close();
        return flag;
    }
}  


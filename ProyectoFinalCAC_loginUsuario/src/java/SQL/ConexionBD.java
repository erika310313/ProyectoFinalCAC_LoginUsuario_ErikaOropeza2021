
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;




public class ConexionBD {
    
    private static String url = "jdbc:mysql://localhost:3306/tienda_bd";
    private static String usuario = "erika";
    private static String contrasenia = "130811";
    
//    private static Connection conexion;
//    private static PreparedStatement sentenciaPreparada;
//    private static ResultSet resultado;
    
    public static Connection conectar(){
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasenia);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        
        
        return conexion;
    }
    
//    public static void main(String[] args){
//        
//        
//        try {
//            conexion = conectar();
//            String consulta = "INSERT INTO usuarios (usuario, nombre, apellido, documento, email, contrasenia) VALUES ('dvd', 'david', 'vazquez', '96542856', 'david@gmail.com', '211231')";
//            sentenciaPreparada = conexion.prepareStatement(consulta);
//            int i = sentenciaPreparada.executeUpdate();
//            
//            if(i > 0){
//                System.out.println("Se guardaron los datos");
//            }else{
//                System.out.println("NO se guardaron los datos");
//            }
//            conexion.close();
//            
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//        
//    }
    
    
    
    
}

package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetodosSQL {

    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultado;

    public boolean registrarUsuario(String usuario, String nombre, String apellido, String documento, String email, String contrasenia) {
        boolean registro = false;

            try {
                conexion = ConexionBD.conectar();
                String consulta = "INSERT INTO usuarios (usuario, nombre, apellido, documento, email, contrasenia) VALUES (?, ?, ?, ?, ?, ?)";
                sentenciaPreparada = conexion.prepareStatement(consulta);
                sentenciaPreparada.setString(1, usuario);
                sentenciaPreparada.setString(2, nombre);
                sentenciaPreparada.setString(3, apellido);
                sentenciaPreparada.setString(4, documento);
                sentenciaPreparada.setString(5, email);
                sentenciaPreparada.setString(6, contrasenia);

                int resultadoInsercion = sentenciaPreparada.executeUpdate();

                if (resultadoInsercion > 0) {
                    registro = true; //El usuario se ha registrado
                    System.out.println("Se ha registrado el usuario");
                } else {
                    registro = false; //El usuario NO se ha registrado
                    System.out.println("NO se ha registrado el usuario");
                }

                conexion.close();

            } catch (SQLException e) {
                System.out.println("Error: " + e);
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                }
            }

        System.out.println("Valor del registro: " + registro);
        return registro;
    }
    
    
    public boolean buscarUsuarioRepetidoBD(String usuario){
        boolean usuarioRepetido = false;
        
            try {
                conexion = ConexionBD.conectar();
                String consulta = "SELECT usuario FROM usuarios WHERE usuario = ?";
                sentenciaPreparada = conexion.prepareStatement(consulta);
                sentenciaPreparada.setString(1, usuario);
                resultado = sentenciaPreparada.executeQuery();

                if(resultado.next()) {
                    usuarioRepetido = true; //El usuario esta repetido en la BD
                }else{
                    usuarioRepetido = false; //El usuario NO esta repetido en la BD
                }

                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                }
            }
        
        System.out.println("El valor del usuario Repetido en el METODO es: " + usuarioRepetido);
        return usuarioRepetido;
    }
    
    
    public boolean buscarUsuarioInicioSesion(String usuario, String contrasenia){
        boolean iniciarSesion = false;
    
            try {
                conexion = ConexionBD.conectar();
                String consulta = "SELECT usuario, contrasenia FROM usuarios WHERE usuario = ? AND contrasenia = ?;";
                sentenciaPreparada = conexion.prepareStatement(consulta);
                sentenciaPreparada.setString(1, usuario);
                sentenciaPreparada.setString(2, contrasenia);
                resultado = sentenciaPreparada.executeQuery();

                if(resultado.next()) {
                    iniciarSesion = true; //El usuario puede iniciar sesion porque esta registrado
                }else{
                    iniciarSesion = false; //El usuario no puede iniciar sesion porque no esta registrado
                }

                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                }
            }
        
        System.out.println("El valor de iniciarSecion en el METODO es: " + iniciarSesion);
        return iniciarSesion;
    }
    
    
    public String buscarNombre(String usuario){
        String nombre = null;
        
            try {
                conexion = ConexionBD.conectar();
                String consulta = "SELECT nombre FROM usuarios WHERE usuario = ?";
                sentenciaPreparada = conexion.prepareStatement(consulta);
                sentenciaPreparada.setString(1, usuario);
                resultado = sentenciaPreparada.executeQuery();
                
                if (resultado.next()) { //El usuario fue encontrado y obtenemos el nombre
                    nombre = resultado.getString("nombre"); 
                }else{
                    nombre = null; //El usuario no fue encontrado y no obtenemos el nombre
                }
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }finally{
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                }
            }
        
            System.out.println("El valor del nombre en los METODOs SQL es: " + nombre);
        return nombre;
    
    }
    
    
    
    
}

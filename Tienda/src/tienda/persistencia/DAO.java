
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    //Metodos para acceder a la base de datos
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    //Propiedades de la base de datos
    private final String BD = "Tienda";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    //Conectarse a la base de datos
    protected void conectar() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL + BD + "?useSSL = false", USER, PASSWORD);
            System.out.println("CONEXION EXITOSA");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("FALLO CONEXION");
            System.out.println("Error " + ex);
        }
    }

    //Desconectarse de la base de datos
    protected void desconectar() throws SQLException {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    //Insetar Modificar o Eliminar
    protected void insModDel(String sql){
        try {
            conectar();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }
    
    //Consultar base de datos
    protected void consultar (String sql) throws SQLException{
        try {
            conectar();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}

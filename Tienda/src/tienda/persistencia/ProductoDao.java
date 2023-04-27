package tienda.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import tienda.entidades.Producto;

public class ProductoDao extends DAO {

    //Consultar lista de productos
    public ArrayList<Producto> consultarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM producto;";
            consultar(sql);
            Producto p = null;
            ArrayList<Producto> listaP = new ArrayList();
            while (resultado.next()) {
                p = new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
                listaP.add(p);
            }
            return listaP;
        } catch (SQLException ex) {
            desconectar();
            throw new Exception("Error... " + ex);
        }
    }

    //c) Listar aquellos productos que su precio esté entre 120 y 202.
    public ArrayList<Producto> consultaC() throws SQLException {
        String sql = "SELECT nombre, precio FROM producto WHERE precio BETWEEN 120 AND 202;";
        consultar(sql);
        Producto p = null;
        ArrayList<Producto> listaP = new ArrayList();
        while (resultado.next()) {
            p = new Producto();
            p.setNombre(resultado.getString(1));
            p.setPrecio(resultado.getInt(2));
            listaP.add(p);
        }
        return listaP;
    }

    //f) Ingresar un producto a la base de datos.
    public void consultaF(String nombre, double precio, int codigo_fabricante) {
        String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) "
                + "VALUES (default, '" + nombre + "', " + precio + ", " + codigo_fabricante + ");";
        insModDel(sql);
    }

    

}

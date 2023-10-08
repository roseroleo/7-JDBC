
package tienda.persistencia;

public class FabricanteDao extends DAO {
    //g) Ingresar un fabricante a la base de datos
    public void consultaG(String nombre) {
        String sql = "INSERT INTO fabricante (codigo, nombre)"
                + "VALUES (default, '" + nombre + "');";
        insModDel(sql);
    }
}

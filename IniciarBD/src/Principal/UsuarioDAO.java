//Clase hija extiende de DAO
package Principal;

import iniciarbd.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public final class UsuarioDAO extends DAO {

    //Guardar datos del usuario de la BD
    public void guardarUsuario(Usuario u) throws Exception {
        try {
            if (u == null) {
                throw new Exception("Debe ingresar un usuario");
            }
            //Llena los datos en la BD
            String sql = "INSERT INTO Usuario (correoElectronico, clave)"
                    + "VALUES ('" + u.getCorreoElectronico() + "','" + u.getClave() + "' );";
            insModDel(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    //Modificar datos del usuario
    public void modificarUsuario(Usuario u) throws Exception {
        try {
            if (u == null) {
                throw new Exception("Debe ingresar un usuario a modificar");
            }
            //Llena los datos en la BD
            String sql = "UPDATE Usuario SET clave = '" + u.getClave()
                    + "' WHERE correoElectronico = '" + u.getCorreoElectronico() + "';";
            insModDel(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    //Eliminar un usuario
    public void eliminarUsuario(Usuario u) {
        try {
            if (u == null) {
                throw new Exception("Debe ingresar un usuario a eliminar");
            }
            String sql = "DELETE FROM Usuario WHERE id = '" + u + "';";
            insModDel(sql);
        } catch (Exception e) {
        }
    }

    //Consultar lista de usuarios
    public Collection<Usuario> listarUsuarios() throws Exception {
        try {
            String sql = "SELECT correoElectronico, clave FROM Usuario;";
            consultar(sql);
            Usuario u = null;
            Collection<Usuario> usuarios = new ArrayList();
            while (resultado.next()) {
                u = new Usuario();
                u.setCorreoElectronico(resultado.getString(1)); //1 = correoElectronico
                u.setClave(resultado.getString(2)); //2 = clave
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException e) {
//            e.printStackTrace();
            desconectar();
            throw new Exception("Error ");
        }
    }
    
    //Buscar un usuario por correoElectrònico
    public Usuario buscarPorCorreoE(String cE) throws Exception {
        try {
            String sql = "SELECT * FROM Usuario WHERE correoElectronico = '" + cE + "';";
            consultar(sql);
            Usuario u = null;
            while (resultado.next()) {
                u = new Usuario();
                u.setId(resultado.getInt(1));
                u.setCorreoElectronico(resultado.getString(2));
                u.setClave(resultado.getString(3));
            }
            return u;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
}

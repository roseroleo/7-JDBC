package Servicio;

import Principal.UsuarioDAO;
import iniciarbd.Usuario;
import java.util.Scanner;

public class UsuarioService {

    //Relaciona el servicio con el usuario
    public UsuarioService() {
    }
    
    private UsuarioDAO dao;

    public UsuarioService(UsuarioDAO dao) {
        this.dao = dao;
    }

    //Crear un nuevo usuario de la BD
    public void crearUsuario() throws Exception {
        Scanner lr = new Scanner(System.in);
        String correoElectronico = "";
        String clave = "";
        boolean correcto = true;
        do {
            System.out.print("Ingrese su correo electronico \n");
            correoElectronico = lr.next();
            System.out.print("Ingrese su clave ");
            clave = lr.next();
            validar(correoElectronico, clave);
        } while (!correcto);
        Usuario u = new Usuario();
        u.setCorreoElectronico(correoElectronico);
        u.setClave(clave);
        dao.guardarUsuario(u);
    }

    //Validar entradas
    public boolean validar(String cE, String cL) throws Exception {
        boolean correcto = true;
        try {
            if (cE == null || cE.trim().isEmpty() || cE.contains("@") == false) {
                correcto = false;
                System.out.println("Ingrese un correo electrónico válido");
            }
            if (cL == null || cL.trim().isEmpty()) {
                correcto = false;
                System.out.println("Ingrese una clave válida");
            }
            if (dao.buscarPorCorreoE(cE) != null) {
                correcto = false;
                throw new Exception("Ya existe un usuario con el correo " + cE);
            }
        } catch (Exception e) {
//            System.out.println("Que paso aqui");
//            throw e;
        }
        return correcto;
    }
}

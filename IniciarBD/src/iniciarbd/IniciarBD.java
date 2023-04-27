/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iniciarbd;

import Principal.UsuarioDAO;
import Servicio.UsuarioService;

/**
 *
 * @author Leonardo
 */
public class IniciarBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        Usuario u1 = new Usuario();
        
        UsuarioService us = new UsuarioService();
        us.crearUsuario();
        System.out.println("Volver");
    }
    
}

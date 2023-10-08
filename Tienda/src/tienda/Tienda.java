/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tienda;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.servicios.ProductoService;
import tienda.servicios.fabricanteService;

/**
 *
 * @author roser
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductoService ps = new ProductoService();
        fabricanteService fs = new fabricanteService();
        
        Scanner lr = new Scanner(System.in).useDelimiter("\n");
        
        String opcion = "";
        boolean correcto = false, salir = false;
        try {
            do {
                System.out.println("\n*** MENU DE OPCIONES ***");
                System.out.println("*******************************************************************************\n"
                        + "a) Lista el nombre de todos los productos que hay en la tabla producto.\n"
                        + "b) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
                        + "c) Listar aquellos productos que su precio esté entre 120 y 202.\n"
                        + "d) Buscar y listar todos los Portátiles de la tabla producto.\n"
                        + "e) Listar el nombre y el precio del producto más barato.\n"
                        + "f) Ingresar un producto a la base de datos.\n"
                        + "g) Ingresar un fabricante a la base de datos.\n"
                        + "h) Editar un producto con datos a elección.\n"
                        + "s) Salir.\n"
                        + "*******************************************************************************");
                opcion = lr.next().toLowerCase();
                switch (opcion) {
                    case "a":
                        ps.listarPorNombre();
                        break;
                    case "b":
                        ps.listarPorNombrePrecio();
                        break;
                    case "c":
                        ps.listarPorPrecio120a220();
                        break;
                    case "d":
                        ps.buscarPorProducto();
                        break;
                    case "e":
                        ps.buscarMenorPrecio();
                        break;
                    case "f":
                        ps.ingresarProducto();
                        break;
                    case "g":
                        fs.IngresarFabricante();
                        break;
                    case "h":
                        ps.editarProducto();
                        break;
                    case "s":
                        salir = true;
                        break;
                    default:
                        throw new AssertionError();
                }
            } while (!correcto && !salir);
        } catch (Exception e) {
            System.out.println("Error en menu " + e);
        }
    }

}



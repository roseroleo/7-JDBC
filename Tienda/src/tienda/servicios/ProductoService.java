package tienda.servicios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDao;

public class ProductoService {

    Scanner lr = new Scanner(System.in);
    ProductoDao dao = new ProductoDao();

    //a) Lista el nombre de todos los productos que hay en la tabla producto
    public void listarPorNombre() throws Exception {
        ArrayList<Producto> listaProductos = dao.consultarProductos();
        System.out.println("\nLISTA DE PRODUCTOS");
        for (Producto aux : listaProductos) {
            System.out.println(aux.getNombre());
        }
    }

    //b) Lista los nombres y los precios de todos los productos de la tabla producto. 
    public void listarPorNombrePrecio() throws Exception {
        ArrayList<Producto> listaProductos = dao.consultarProductos();
        for (Producto aux : listaProductos) {
            System.out.print(aux.getNombre() + " " + aux.getPrecio());
            System.out.println("");
        }
    }

    //c) Listar aquellos productos que su precio esté entre 120 y 220. 
    public void listarPorPrecio120a220() throws Exception {
        ArrayList<Producto> listaProductos = dao.consultaC();
        for (Producto aux : listaProductos) {
            System.out.print(aux.getNombre() + " " + aux.getPrecio());
            System.out.println("");
        }
    }

    //f) Ingresar un producto a la base de datos.
    public void ingresarProducto() {
        System.out.println("*** INGRESAR PRODUCTO ***\n");
        System.out.println("Nombre ");
        String nombre = lr.next();
        System.out.println("Precio ");
        double precio = lr.nextInt();
        System.out.println("Codigo fabricante ");
        int codigo_fabricante = lr.nextInt();
        dao.consultaF(nombre, precio, codigo_fabricante);
    }

    //d) Buscar y listar todos los Portátiles de la tabla producto. 
    public void buscarPorProducto() throws SQLException {
        System.out.println("Nombre ");
        String producto = lr.next();
        ArrayList<Producto> listaProductos = dao.consultaD(producto);
        for (Producto aux : listaProductos) {
            System.out.print(aux.getNombre() + " " + aux.getPrecio());
            System.out.println("");
        }
    }

    //e) Listar el nombre y el precio del producto más barato. 
    public void buscarMenorPrecio() throws Exception {
        ArrayList<Producto> listaProductos = dao.consultaE();
        for (Producto aux : listaProductos) {
            System.out.print(aux.getNombre() + " " + aux.getPrecio());
            System.out.println("");
        }
    }

    //h) Editar un producto con datos a elección. 
    public void editarProducto() throws SQLException {
        System.out.println("Nombre del producto a editar\n");
        String producto = lr.next();
        System.out.println("Precio\n");
        double precio = lr.nextDouble();
        System.out.println("Codigo del fabricante\n");
        int codigoFabricante = lr.nextInt();
        dao.consultaF(producto, precio, codigoFabricante);
        
        
    }

}


/*
 */

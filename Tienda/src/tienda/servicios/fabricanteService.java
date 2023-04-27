package tienda.servicios;

import java.util.Scanner;
import tienda.persistencia.FabricanteDao;
import tienda.persistencia.ProductoDao;

public class fabricanteService {
    
     FabricanteDao dao = new FabricanteDao();
    //g) Ingresar un fabricante a la base de datos
    public void IngresarFabricante(){
        Scanner lr = new Scanner(System.in);
        System.out.println("*** INGRESAR FABRICANTE ***\n");
        System.out.println("Nombre ");
        String nombre = lr.next();
        dao.consultaG(nombre);
    }
}

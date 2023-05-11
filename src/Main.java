import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int opcion = 0;
        Peliculas peliculas = new Peliculas();
        Pelicula p = null;
        ArrayList<Pelicula> listado_peliculas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


        do {

            System.out.println("0.Salir del programa");
            System.out.println("1.Crear Tabla Película");
            System.out.println("2.Eliminar tabla Película");
            System.out.println("3.Crear película ");
            System.out.println("4.Eliminar Película por id");
            System.out.println("5.Buscar película por id e imprimir información");
            System.out.println("6.Buscar e imprimir todas las peliculas");
            System.out.println("7.Buscar por genero y orden descendente de estreno e imprimir");
            System.out.println("....");
            opcion = sc.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("¡Gracias por usar el programa!");break;
                case 1:
                    peliculas.crearTabla();break;
                case 2:
                    peliculas.eliminarTabla();break;

                case 3:
                    System.out.println("Indicame el id");
                    int id = sc.nextInt();

                    System.out.println("Indicame el titulo");
                    String titulo = sc.next();

                    System.out.println("Indicame el genero ROMANTICA, MIEDO, COMEDIA");
                    String genero = sc.next().toUpperCase();

                    System.out.println("Indicame el estreno");
                    int estreno = sc.nextInt();

                     p = new Pelicula(id,titulo,genero,estreno);
                    peliculas.crearPelicula(p);break;

                case 4:

                    System.out.println("Indícame el id a eliminar");
                    id = sc.nextInt();
                    peliculas.eliminarPelicula(id);break;

                case 5:

                    System.out.println("Dime el id a buscar");
                    id = sc.nextInt();
                    System.out.println(peliculas.buscarPelicula(id));break;

                case 6:
                    listado_peliculas = peliculas.buscarTodo();

                    for (Pelicula e : listado_peliculas){
                        System.out.println(e.toString());
                    };break;


                case 7:

                    System.out.println("Indicame el genero ROMANTICA, MIEDO, COMEDIA");
                    genero = sc.next().toUpperCase();

                    listado_peliculas = peliculas.buscarPorGeneroOrdenarEstreno(genero);
                    for (Pelicula e : listado_peliculas){
                        System.out.println(e.toString());
                    };break;


            }

        }while (opcion!=0);


       /* private static void imprimir_arraylist(ArrayList<Pelicula> listado_peliculas){
            //por si se estima necesario


        }
        */
    }
}
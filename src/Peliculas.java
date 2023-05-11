import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Peliculas implements PeliculasInterface {

    public static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica3","root","Noteloesperas1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public  void crearTabla() throws SQLException {
        String query1 = "use practica3";

        String query = "create table Pelicula(" +
                "id int primary key," +
                "titulo varchar(100) not null," +
                "genero varchar(50)," +
                "estreno int)";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        /**
         *
         * PREGUNTAR SI ESTOS MENSAJES DE QUE SI SE HA INSERTADO CORRECTAMENTE FUNCIONA.
         *
         */
        System.out.println("Tabla creada correctamente");
    }

    @Override
    public  void eliminarTabla() throws SQLException {
        String query1 = "use practica3";

        String query = "drop table Pelicula";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        System.out.println("Tabla borrada correctamente");
    }

    @Override
    public  void crearPelicula(Pelicula p) throws SQLException {

        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("insert into Pelicula values (?,?,?,?)");

        ps.setInt(1,p.getId());
        ps.setString(2,p.getTitulo());
        ps.setString(3, p.getGenero().toString());
        ps.setInt(4,p.getEstreno());
        ps.executeUpdate();
        System.out.println("Película insertada correctamente");

    }

    @Override
    public void eliminarPelicula(int id) throws SQLException {
        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("delete from Pelicula where id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Pelicula eliminada correctamente");


    }

    @Override
    public Pelicula buscarPelicula(int id) throws SQLException {
        Pelicula p = null;

        String query1 = "use practica3";
        PreparedStatement ps = conn.prepareStatement("select * from Pelicula where id = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){

            p= new Pelicula(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));

        }

        return p;
    }

    @Override
    public ArrayList<Pelicula> buscarTodo() throws SQLException {
        //AQUI ELLA PONE EL ARRAYLIST POR DEFECTO, YO LO CREE ARRIBA, HAY ALGUN PROBLEMA SI USO ELMIO?
        //AHORA MISMO ESTA EN USO EL SUYO
        ArrayList<Pelicula> lista= new ArrayList<>();

        Pelicula p = null;  //PREGUNTAR SI EL NULL ES MEJOR TENERLO AQUI O ARRIBA?

        PreparedStatement ps = conn.prepareStatement("select * from Pelicula");
        ResultSet rs = ps.executeQuery();


        while (rs.next()){

            p = new Pelicula(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4));
            lista.add(p);

        }

        return lista;
    }

    @Override
    public ArrayList<Pelicula> buscarPorGeneroOrdenarEstreno(String genero) throws SQLException {

        ArrayList<Pelicula> lista=new ArrayList<>();
        Pelicula p = null;

        PreparedStatement ps = conn.prepareStatement("select * from Pelicula where genero = ?");
        ps.setString(1,genero);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            p = new Pelicula(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4));
            lista.add(p);

        }

        lista.sort(Comparator.comparing(Pelicula::getEstreno).reversed());


        return lista;
    }
}

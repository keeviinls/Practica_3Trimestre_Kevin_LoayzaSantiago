public class Pelicula {
   //atributos

    private int id;
    private String titulo;
    private Genero genero;
    private int estreno;


    //constructor parametrizado

    public Pelicula(int id, String titulo, String genero, int estreno) {
        this.id = id;
        this.titulo = titulo;
        this.genero = Genero.valueOf(genero);
        this.estreno = estreno;
    }

    //getter setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(String  genero) {
        this.genero = Genero.valueOf(genero);
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }




    //metodo tostring

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero=" + genero +
                ", estreno=" + estreno +
                '}';
    }
}

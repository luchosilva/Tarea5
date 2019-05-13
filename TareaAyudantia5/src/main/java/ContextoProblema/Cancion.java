package ContextoProblema;

public class Cancion {

    private String nombre;
    private String autor;
    private String album;
    private int id;
    private String ano;
    private String letra;

    public Cancion(String nombre,String autor,String album,int id,String ano,String letra){
        this.nombre=nombre;
        this.autor=autor;
        this.album=album;
        this.id=id;
        this.ano=ano;
        this.letra=letra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getAlbum() {
        return album;
    }

    public int getId() {
        return id;
    }

    public String getAno() {
        return ano;
    }

    public String getLetra() {
        return letra;
    }
}
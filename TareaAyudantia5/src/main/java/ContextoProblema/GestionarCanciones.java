package ContextoProblema;

import java.util.ArrayList;

public class GestionarCanciones {

    public ArrayList<Cancion> canciones;

    public GestionarCanciones(){
        canciones = new ArrayList<Cancion>();
    }

    //parametro tipo Cancion
    public void agregarCancion(Cancion c) {
        canciones.add(c);
    }

    //parametro entero
    public void borrarCancion(int id) {
        for (int i = 0; i < canciones.size(); i++) {
            Cancion aux = canciones.get(i);
            if (aux.getId() == id) {
                canciones.remove(i);
            } else {
                System.out.println("ID ingresado no coincide");
            }
        }
    }

    public void mostrarLista() {
        System.out.println("Canciones:");
        for (int i = 0; i < canciones.size(); i++) {
            Cancion aux = canciones.get(i);
            System.out.println("ID: "+aux.getId()+", Nombre de la canción: "+aux.getNombre()+", Interprete: "+aux.getAutor()+", Album: "+aux.getAlbum()+", Año: "+aux.getAno()+", Letra: "+aux.getLetra());
        }
    }

}

package Interfaz;

import ContextoProblema.Cancion;
import ContextoProblema.GestionarCanciones;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Interfaz {

    private GestionarCanciones GestionarCanciones;
    private int ID;

    public Interfaz() {
        GestionarCanciones = new GestionarCanciones();
        this.ID = 0;
    }

    public void menu() {
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("Seleccione una opción:");
                System.out.println("[1].-Agregar canción");
                System.out.println("[2].-Eliminar canción");
                System.out.println("[3].-Agregar canción/es desde un .txt");
                System.out.println("[4].-Mostrar canciones almacenadas");
                System.out.println("[5].-Salir");
                int opcion = leerEntero();
                if (opcion > 5 || opcion < 1) {
                    System.out.println("Opción no valida,intentelo nuevamente:");
                } else {
                    switch (opcion) {
                        case 1: {
                            almacenarCancion();
                            break;
                        }
                        case 2: {
                            System.out.println("Ingrese el ID de la canción que deseas borrar");
                            int numeroCancionABorrar = leerEntero();
                            GestionarCanciones.borrarCancion(numeroCancionABorrar);
                            break;
                        }
                        case 3: {
                            System.out.println("Ingrese la ruta de los datos de la canción: ");
                            String ruta = leerCadena();
                            leerArchivo(ruta);
                            break;
                        }
                        case 4: {
                            GestionarCanciones.mostrarLista();
                            break;
                        }
                        case 5: {
                            salir = true;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Valor no esperado,intentelo nuevamente:");
            }
        }
    }

    public void almacenarCancion() { //Pide los datos del objeto cancion y luego los almacena en un arraylist
        System.out.println("Ingrese el nombre de la canción: ");
        String nombre = leerCadena();
        System.out.println("Ingrese el nombre del artista: ");
        String autor = leerCadena();
        System.out.println("Ingrese el nombre del album: ");
        String album = leerCadena();
        System.out.println("Ingrese el año de la canción: ");
        String ano = leerCadena();
        System.out.println("Ingrese la letra de la canción: ");
        String letra = leerCadena();
        Cancion can = new Cancion(nombre, autor, album, ID++, ano, letra);
        GestionarCanciones.agregarCancion(can);
    }

    //parametro String
    //retorno boolean
    public boolean leerArchivo(String ruta) { //Lee un archivo .txt y guarda sus datos en objetos de tipo cancion
        File fichero = new File(ruta);
        Scanner s = null;
        String linea = "";
        if (fichero.exists()) {
        System.out.println("... Leemos el contenido del fichero ...");
        try {
            s = new Scanner(fichero);
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio un error");
        }
        try { // Obtengo los datos de las canciones del fichero
            while ((linea = s.nextLine()) != null) { // Obtengo una linea del fichero
                String[] cortarString = linea.split(",");
                Cancion can = new Cancion(cortarString[0], cortarString[1], cortarString[2], ID++, cortarString[3], pedirLetra(recibirRuta(cortarString[0]))); // Creo un objeto de la clase "Cancion"
                GestionarCanciones.agregarCancion(can); // Añadimos el objeto "Cancion" al ArrayList
            }
        } catch (NullPointerException e) {
            System.out.println();
        } catch (NoSuchElementException e2) {
            System.out.println();
        }
        s.close();
            return true;
        } else {
            return false;
        }
    }

    //parametro String
    //retorto String
    public static String recibirRuta(String nombreCancion) { //recibe una ruta
        System.out.println("Ingrese la ruta de la letra de la canción: " + nombreCancion);
        String ruta = leerCadena();
        return ruta;
    }

    //parametro String
    //retorno String
    public static String pedirLetra(String ruta) {  //lee el .txt de la letra de la cancion y lo almacena en un String
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto;
    }

    //retorno String
    public static String leerCadena() {  //Pide un String
        String palabra = "";
        boolean estado = true;
        while (estado) {
            try {
                Scanner sc = new Scanner(System.in);
                palabra = sc.nextLine();
                estado = false;
            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es una palabra, intentelo nuevamente.");
                estado = true;
            }
        }
        return palabra;
    }

    //retorno entero
    public static int leerEntero() {  //Pide un int
        int num = 0;
        boolean estado = true;
        while (estado) {
            try {
                System.out.println("Ingrese un número");
                Scanner sc = new Scanner(System.in);
                num = sc.nextInt();
                estado = false;

            } catch (InputMismatchException e) {
                System.out.println("El caracter ingresado no es numerico o se encuentra fuera del rango establecido, intentelo nuevamente.");
                estado = true;
            }
        }
        return num;
    }

}


import Interfaz.Interfaz;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.io.IOException;

public class InterfazTest {
    Interfaz i;

    @Before
    public void preparar() {
        i = new Interfaz();
    }

    @Test
    public void pedirLetraTest() throws IOException {
        String esperado="[Intro]\n" +
                "De no ser por esas veces en que cometo la gran\n" +
                "Barbaridad de ponerme a pensar\n" +
                "O por esas otras veces en que cometo la gran\n" +
                "Estupidez de no olvidar\n" +
                "\n" +
                "De meditar mirando al techo al despertar\n" +
                "De imaginar cualquier cosa\n" +
                "De no ser por esas veces en que suelo respirar\n" +
                "Podría jurar que no te recuerdo nada\n" +
                "\n" +
                "[Verso 1]\n" +
                "Y lo peor es que yo te conozco tanto\n" +
                "Que podría recordarte quién eres por si lo olvidas\n" +
                "Y lo peor del caso es que de ti sé tanto\n" +
                "Que podría dictar clases intensivas de tu vida\n" +
                "\n" +
                "Por eso casi sé cuando me estás pensando\n" +
                "Por eso creo saber cuando de mí te olvidas\n" +
                "Y sé que como yo quisieras poder sólo parpadeando\n" +
                "Echar el tiempo atrás en nuestras vidas\n" +
                "\n" +
                "El único detalle es que la ciencia no ha podido\n" +
                "Crear esas maquinitas del tiempo\n" +
                "Por eso creo que nos resulte un poquitico bien jodido\n" +
                "Volver a los días en que tu cuerpo\n" +
                "\n" +
                "Estaba convertido en río sobre el mío\n" +
                "Dejando escapar seguido esos orgasmitos lentos\n" +
                "Que cabe acotar nacían al mismo tiempo\n" +
                "Hasta que un cigarrillo daba fecha de fallecimiento\n" +
                "\n" +
                "[Coro]\n" +
                "Es maquiavélico meditar\n" +
                "A solas donde tú viviste todo con ella\n" +
                "Como una voz que te dice que a las estrellas\n" +
                "Un dedo no puede ocultar, no\n" +
                "\n" +
                "Es maquiavélico meditar\n" +
                "A solas donde tú viviste todo con ella\n" +
                "Como una voz que te dice que a las estrellas\n" +
                "Un dedo no puede ocultar, no\n";
        assertEquals(esperado,i.pedirLetra("maquiavelico.txt"));
    }

    @Test
    public void leerArchivoTest(){ //si se le pasa una ruta incorrecta
        String ruta="nada.txt";
        boolean esperado=false;
        assertEquals(esperado,i.leerArchivo(ruta));
    }

    @Test
    public void leerArchivoTest2(){ //si se le pasa una ruta sin el .tipo_de_archivo (.txt en este caso)
        String ruta="maquiavelo";
        boolean esperado=false;
        assertEquals(esperado,i.leerArchivo(ruta));
    }

    @Test
    public void leerArchivoTest3(){ //si no se pasa nada
        String ruta="";
        boolean esperado=false;
        assertEquals(esperado,i.leerArchivo(ruta));
    }
    
    @Test
    public void agregarCanciontest() {
        GestionarCanciones g = new GestionarCanciones();
        g.agregarCancion(new Cancion());
        Assertions.assertTrue(g.getListaCanciones().get(0)!=null);
    }

}

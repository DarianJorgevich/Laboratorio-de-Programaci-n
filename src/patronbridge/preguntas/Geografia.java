
package patronbridge.preguntas;

import java.util.ArrayList;
import java.util.List;

public class Geografia implements Pregunta {

    private final List<String> preguntasFaciles = new ArrayList<>();
    private final List<String> preguntasDificiles = new ArrayList<>();
    private int preguntaActual = 0;
    private int resultado = 0;
    private final char[] respuestasFaciles = {'a', 'c', 'b', 'b','a'};
    private final char[] respuestasDificiles = {'b','a', 'c', 'a', 'a' };

    public Geografia() {
        preguntasFaciles.add("¿Cuál es la capital de Turquía? \n a) Ankara b) Buenos Aires c) Lima");
        preguntasFaciles.add("¿En qué provincia se encuentra las cataratas del Iguazú? \n a) Rio negro b) Neuquen c) Misiones");
        preguntasFaciles.add("¿Donde se ubica el volcan Lanin? \n a) Rio negro b) Neuquen c) Mendoza");
        preguntasFaciles.add("¿Cuantos continentes hay en la tierra? \n a) 2 b) 6 c) 5");
        preguntasFaciles.add("¿En que continente se ubica Brasil? \n a) America 2 b) Europa c) Asia");
        
        preguntasDificiles.add("¿En qué cordillera se encuentra el Monte Everest? \n a) Andes b) himalaya c) Alpes");
        preguntasDificiles.add("¿Cuál es la isla más grande del mar Caribe? \n a) Cuba b) Haiti c) Jamaica");
        preguntasDificiles.add("¿Qué mar rodea a la isla mexicana de Cozumel? \n a) Mar muerto b) Mar Negro c) Mar Caribe ");
        preguntasDificiles.add("¿Cual es el pais mas poblado de africa? \n a) Nigeria b) Egipto c) Sudafrica ");
        preguntasDificiles.add("¿Dónde se encuentra el río Po? \n a) Italia b) Japon c) China ");
    }
    

    @Override
    public void mostrarPreguntaFacil(int num) {
        System.out.println(preguntasFaciles.get(num));
    }

    @Override
    public char preguntaFacilRespuesta(int num) {
        return respuestasFaciles[num];
    }

    @Override
    public void mostrarPreguntaDificil(int num) {
        System.out.println(preguntasDificiles.get(num));
    }

    @Override
    public char preguntaDificilRespuesta(int num) {
        return respuestasDificiles[num];
    }

    @Override
    public int obtenerResultadoFinal() {
        return this.resultado;
    }

    @Override
    public int obtenerCantidadPreguntasFaciles() {
        return this.preguntasFaciles.size();
    }

    @Override
    public int obtenerCantidadPreguntasDificiles() {
        return this.preguntasDificiles.size();
    }

    @Override
    public void siguientePregunta() {
        preguntaActual++;

    }

    @Override
    public void marcarRespuestaCorrecta() {
        resultado++;

    }

    @Override
    public void limpiar() {
        preguntaActual = 0;
        resultado = 0;
    }

}

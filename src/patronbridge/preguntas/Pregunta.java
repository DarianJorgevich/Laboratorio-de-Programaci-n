
package patronbridge.preguntas;



public interface Pregunta {
    
    public void mostrarPreguntaFacil(int num);
    public char preguntaFacilRespuesta(int num);
    public void mostrarPreguntaDificil(int num);
    public char preguntaDificilRespuesta(int num);
    public int obtenerResultadoFinal();
    public int obtenerCantidadPreguntasFaciles();
    public int obtenerCantidadPreguntasDificiles();
    public void siguientePregunta();
    public void marcarRespuestaCorrecta();
    public void limpiar();
}

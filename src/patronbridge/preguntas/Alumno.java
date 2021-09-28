
package patronbridge.preguntas;


public abstract class Alumno {

    protected Pregunta pregunta;
    protected String nombre;

    protected Alumno(String nombre, Pregunta pregunta) {
        this.nombre = nombre;
        this.pregunta = pregunta;
    }

    public void siguientePregunta() {
        pregunta.siguientePregunta();
    }

    public void respuestaCorrecta() {
        pregunta.marcarRespuestaCorrecta();
    }

    public abstract void mostrarPregunta(int num);
    public abstract void verificarRespuesta(int num, char respuestaUser);
    public abstract void mostrarResultados();
    public abstract int obtenerCantidadPreguntas();

}

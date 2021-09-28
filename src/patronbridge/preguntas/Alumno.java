/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronbridge.preguntas;

/**
 *
 * @author Lucas
 */
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
        pregunta.respuestaCorrecta();
    }

    public abstract void mostrarPregunta(int num);
    public abstract void verificarRespuesta(int num, char respuestaUser);
    public abstract void mostrarResultados();
    public abstract int obtenerCantidadPreguntas();

}

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

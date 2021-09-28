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
    
    public void preguntaFacilMostrar(int num);
    public char preguntaFacilRespuesta(int num);
    public void preguntaDificilMostrar(int num);
    public char preguntaDificilRespuesta(int num);
    public int obtenerResultado();
    public int obtenerCantidadPreguntasFaciles();
    public int obtenerCantidadPreguntasDificiles();
    public void siguientePregunta();
    public void respuestaCorrecta();
    public void limpiar();
}

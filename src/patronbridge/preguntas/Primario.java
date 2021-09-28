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
public class Primario extends Alumno {
    
    public Primario (String nombre, Pregunta pregunta){
        super(nombre,pregunta);
        
    }
    
    @Override
    public void mostrarPregunta(int num){
        pregunta.preguntaFacilMostrar(num);
    }
    
    @Override
    public void verificarRespuesta(int num, char respuestaUser){
        char resPregunta = pregunta.preguntaFacilRespuesta(num);
        if(respuestaUser==resPregunta){
            System.out.println("Respuesta correcta!");
            this.respuestaCorrecta();
        }
        else{
            System.out.println("Respuesta incorrecta! La solucion es: "+resPregunta+")");
        }
        System.out.println("\n");
        
    }
    
    @Override
    public int obtenerCantidadPreguntas(){
        return pregunta.obtenerCantidadPreguntasFaciles();
    }
    
    @Override
    public void mostrarResultados(){
        int respuestasCorrectas = pregunta.obtenerResultado();
        int cantPreguntas = pregunta.obtenerCantidadPreguntasFaciles();
        System.out.println(this.nombre+ ", respondiste bien: "+respuestasCorrectas+" de " + cantPreguntas+ " preguntas");
        
        this.respuestaPrimario((respuestasCorrectas*100)/cantPreguntas);
        
        pregunta.limpiar();
    }
    
    public void respuestaPrimario(int avg){
       
        if (avg==100){
            System.out.println("Excelente, respondiste bien todas las preguntas!");
        }
        else if (avg>60){
            System.out.println("Es muy buen intento!");
        }
        else if (avg>20){
            System.out.println("Respondiste de manera regular, falta un poco de estudio");
        } 
        else{
            System.out.println("Muy mal desempeño :( ");
        }
    }
   
    
}

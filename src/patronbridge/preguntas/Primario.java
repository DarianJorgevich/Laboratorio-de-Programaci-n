
package patronbridge.preguntas;

/*
La idea es que el alumno primario utilice y responda preguntas faciles de la interfaz pregunta
*/

public class Primario extends Alumno {
    
    public Primario (String nombre, Pregunta pregunta){
        super(nombre,pregunta);
        
    }
    
    @Override
    public void mostrarPregunta(int num){
        pregunta.mostrarPreguntaFacil(num);
    }
    
    @Override
    public void verificarRespuesta(int num, char respuestaUser){
        //resPregunta es la opcion correcta a la pregunta
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
        int respuestasCorrectas = pregunta.obtenerResultadoFinal();
        int cantPreguntas = pregunta.obtenerCantidadPreguntasFaciles();
        System.out.println(this.nombre+ ", respondiste bien: "+respuestasCorrectas+" de " + cantPreguntas+ " preguntas");
        
        this.respuestaPrimario((respuestasCorrectas*100)/cantPreguntas);
        //una vez que se muestran los resultados se limpian los resultados para iniciar la trivia nuevamente
        pregunta.limpiar();
    }
    
    public void respuestaPrimario(int avg){
       //modulo que dado el porcentaje de respuestas correctas el alumno tendra distintas respuestas del sistema 
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

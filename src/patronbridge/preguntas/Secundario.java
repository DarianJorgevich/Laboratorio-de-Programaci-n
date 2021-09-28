
package patronbridge.preguntas;

/*
La idea es que el alumno secundario utilice y responda preguntas dificiles de la interfaz pregunta
*/ 
public class Secundario extends Alumno {
    
    
    public Secundario (String nombre, Pregunta pregunta){
        super(nombre,pregunta);
        
    }
    
    @Override
    public void mostrarPregunta(int num){
        pregunta.mostrarPreguntaDificil(num);
    }
    
    @Override
    public void verificarRespuesta(int num, char respuestaUser){
        char resPregunta = pregunta.preguntaDificilRespuesta(num);
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
        return pregunta.obtenerCantidadPreguntasDificiles();
    }
    
    @Override
    public void mostrarResultados(){
        int respuestasCorrectas = pregunta.obtenerResultadoFinal();
        int cantPreguntas = pregunta.obtenerCantidadPreguntasDificiles();
        System.out.println(this.nombre+ ", respondiste bien: "+respuestasCorrectas+" de " + cantPreguntas+ " preguntas");
        
        this.respuestasSecundario((respuestasCorrectas*100)/cantPreguntas);
        
        pregunta.limpiar();
    }
    
    public void respuestasSecundario(int avg){
        if (avg==100){
            System.out.println("Excelente, respondiste bien todas las preguntas!");
        }
        else if (avg>=70){
            System.out.println("Es muy buen intento, segui asi!");
        }
        else if (avg>=40){
            System.out.println("Respondiste de manera regular, falta un poco de estudio");
        } 
        else{
            System.out.println("Muy mal desempeño :( ");
        }
    }

    
}

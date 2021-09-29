
package patronbridge.preguntas;


public abstract class Alumno {
    
    //Cada alumno va a contener la interfaz que gestiona las preguntas y los resultados
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

    //metodos abstractos que deberan estar implementados por los hijos 
    
    //se muestra la pregunta elegida por parametro
    public abstract void mostrarPregunta(int num);
    //el alumno coloca su respuesta y el sistema dice si es correcta o no
    public abstract void verificarRespuesta(int num, char respuestaUser);
    //Se muestra el resultado final una vez finalizada la trivia 
    public abstract void mostrarResultados();
    //obtener la cantidad de preguntas que hay en la interface 
    public abstract int obtenerCantidadPreguntas();

}

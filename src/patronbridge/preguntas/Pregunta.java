
package patronbridge.preguntas;

/*
La interface pregunta va a contar con una serie de preguntas faciles y dificiles
*/

public interface Pregunta {
    
    public void mostrarPreguntaFacil(int num);                                  //Dado un entero muestra la pregunta facil que se ubica en esa posicion 
    public char preguntaFacilRespuesta(int num);                                //Devuelve la opcion correcta de la pregunta facil que se ubica en "num"
    public void mostrarPreguntaDificil(int num);                                //Dado un entero muestra la pregunta dificil que se ubica en esa posicion 
    public char preguntaDificilRespuesta(int num);                              //Devuelve la opcion correcta de la pregunta dificil que se ubica en "num"
    public int obtenerResultadoFinal();                                         //Devuelve el resultado final de la trivia
    public int obtenerCantidadPreguntasFaciles();                               //Devuelve la cantidad de preguntas faciles que hay actualmente
    public int obtenerCantidadPreguntasDificiles();                             //Devuelve la cantidad de preguntas dificiles que hay actualmente
    public void siguientePregunta();                                            //Indicamos a la clase que queremos operar sobre otra pregunta
    public void marcarRespuestaCorrecta();                                      //Se suma un punto por respuesta correcta
    public void limpiar();                                                      //vuelve los valores (resultado y pregunta actual) a 0, por si algun alumno quiere reiniciar la trivia
}


package patronbridge.preguntas;

import java.util.Scanner;


public class Trivia {
    
    private Alumno al;
    
    public Trivia(Alumno al){
        this.al=al;
        
    }
    //La clase esta encargada de iniciar la trivia segun el alumno y las preguntas implementadas
    public void iniciarTrivia(){
    char res;
        Scanner sc = new Scanner(System.in);
        int cantPreguntasA= al.obtenerCantidadPreguntas();
        System.out.println("================Comienza trivia "+al.nombre+"===============");
        
        for(int i=0;i<cantPreguntasA;i++){
            al.mostrarPregunta(i);
            res= sc.next().charAt(0);
            al.verificarRespuesta(i, res);
            al.siguientePregunta();
        }
        al.mostrarResultados();
        System.out.println("================Finaliza trivia===============\n\n\n");
}
}

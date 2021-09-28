/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronbridge.preguntas;

import java.util.Scanner;

/**
 *
 * @author Lucas
 */
public class Trivia {
    
    private Alumno al;
    
    public Trivia(Alumno al){
        this.al=al;
        
    }
    
    public void iniciarTrivia(){
    char res;
        Scanner sc = new Scanner(System.in);
        int cantPreguntasA= al.obtenerCantidadPreguntas();
        for(int i=0;i<cantPreguntasA;i++){
            al.mostrarPregunta(i);
            res= sc.next().charAt(0);
            al.verificarRespuesta(i, res);
            al.siguientePregunta();
        }
        al.mostrarResultados();
}
}

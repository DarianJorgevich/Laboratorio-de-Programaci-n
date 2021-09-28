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
public class EjemploPreguntas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Primario a= new Primario ("Lucas", new Historia());
        Secundario b= new Secundario ("Darian", new Historia());
        char res;
        Scanner sc = new Scanner(System.in);
        int cantPreguntasA= a.obtenerCantidadPreguntas();
        for(int i=0;i<cantPreguntasA;i++){
            a.mostrarPregunta(i);
            res= sc.next().charAt(0);
            a.verificarRespuesta(i, res);
            a.siguientePregunta();
        }
        a.mostrarResultados();
        
//        int cantPreguntasB= b.obtenerCantidadPreguntas();
//        for(int i=0;i<cantPreguntasB;i++){
//            b.mostrarPregunta(i);
//            res= sc.next().charAt(0);
//            b.verificarRespuesta(i, res);
//            b.siguientePregunta();
//        }
//        b.mostrarResultados();
    }
    
}

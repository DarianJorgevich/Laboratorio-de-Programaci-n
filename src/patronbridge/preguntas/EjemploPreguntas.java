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
        
        Primario a= new Primario ("Lucas", new Geografia());
        Secundario b= new Secundario ("Darian", new Historia());
        Trivia triv = new Trivia(a);
        triv.iniciarTrivia();
    }
    
}

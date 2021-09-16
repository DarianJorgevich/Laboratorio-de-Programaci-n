/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.patrones;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Darian y Lucas
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        while (op != 0) {
            menu();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    menu1();
                    break;
                case 2:
                    String[] t = {"卵", "I am english", "Ich bin Deutscher", "je suis Français", "buon pomeriggio ragazzi", "Olá mundo, sou portugues", "Norsk skrevet tekst"};
                    translate(t);
                    break;
                case 0:
                    String name = sc.nextLine();
                    System.out.println("pusiste: " + name);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
    
    public static void menu() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("        Bienvenidos a nuestro traductor seleccione la opcion que desee");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("1) Traducir al español alguna palabra / oracion");
        System.out.println("2) Correr un ejemplo de prueba por defecto");
        System.out.println("0) Salir");
    }

    public static void menu1() throws IOException {
        Scanner sc = new Scanner(System.in);
        int op = 1, i = 0;
        while (op != 0) {
            menu1Text();
            op = sc.nextInt();
            switch (op) {
                case 1:
                    translateWord();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        }
    }
    
    public static void menu1Text() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Seleccione: ");
        System.out.println("1) Colocar una palabra / oracion");
        System.out.println("0) Salir");
    }

    public static void translate(String[] toTranslate) throws IOException {
        TranslatorApp translatorApp = new TranslatorApp();

        for (String text : toTranslate) {
            translatorApp.translateToSp(text);
        }
    }

    public static void translateWord() throws IOException {
        Scanner sc = new Scanner(System.in);
        String word;
        System.out.println("Escriba la palabra / oracion");
        word = sc.nextLine();
        String[] p = {word};
        translate(p);
    }   
}

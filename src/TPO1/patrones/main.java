/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.patrones;

import java.io.IOException;

/**
 *
 * @author Darian y Juan
 */
public class main {

    public static void main(String[] args) throws IOException {
        //Works as client
        TranslatorApp translatorApp = new TranslatorApp();

        String []toTranslate = {"I am english", "Ich bin Deutscher", "je suis Français","Ciao mondo","Olá mundo, sou portugues","Norsk skrevet tekst","卵"};
       
        for (String text : toTranslate) {
            translatorApp.translateToSp(text);
        }
        
    }

}

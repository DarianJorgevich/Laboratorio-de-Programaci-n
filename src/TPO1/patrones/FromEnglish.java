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
public class FromEnglish implements Handler{
    private Handler next;
    
    @Override
    public Handler getNext(){
        return next;
    }
    @Override
    public void setNext(Handler handler){
        next = handler;
    }
    @Override
    public void translateToSp(String text)throws IOException{
        
        String translatedText = Translator.translate("en", "es", text);
        if(translatedText.equals(text)){
            //Hacer la verificacion en la clase translator
            //El texto traducido es igual al texto orginal(Idioma de origen incorrecto)
            System.out.println("El texto ingresado NO es un texto en Inglés.");
            next.translateToSp(text);
        }else{
            //El texto pudo ser traducido correctamente
            System.out.println("El texto ingresador fué traducido de Inglés a Español.");
            System.out.println("\u001B[32mTexto traducido: "+translatedText+"\n");
        }
    }
}

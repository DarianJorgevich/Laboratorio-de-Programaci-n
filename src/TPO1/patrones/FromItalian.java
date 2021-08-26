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
public class FromItalian implements Handler{
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
        String translatedText = Translator.translate("it", "es", text);
        if(translatedText.equals(text)){
            //El texto traducido es igual al texto orginal(Idioma de origen incorrecto)
            System.out.println("El texto ingresado NO es un texto en Italiano.");
            System.out.println("\u001B[31mEl texto ingresado NO puede ser traducido actualmente.");
        }else{
            //El texto pudo ser traducido correctamente
            System.out.println("El texto ingresador fué traducido de Italiano a Español.");
            System.out.println("\u001B[32mTexto traducido: "+translatedText);
        }
    }
}

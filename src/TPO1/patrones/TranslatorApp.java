/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.patrones;

import java.io.IOException;

/**
 *
 * @author Darian y Lucas
 * Orden de la cadena segun idiomas mas hablados:
 * https://es.wikipedia.org/wiki/Anexo:Idiomas_por_el_total_de_hablantes
 */
public class TranslatorApp implements Handler{
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
    public void translateToSp(String text) throws IOException{
        System.out.println("--Texto a traducir: "+text);
        
        FromEnglish english = new FromEnglish();
        this.setNext(english);

        FromFrench french = new FromFrench();
        english.setNext(french);
        
        FromPortuguese portuguese = new FromPortuguese();
        french.setNext(portuguese);
        
        FromGerman german = new FromGerman();
        portuguese.setNext(german);
        
        FromItalian italian = new FromItalian();
        german.setNext(italian);
        
        next.translateToSp(text);
        System.out.println("\n");
    }
}

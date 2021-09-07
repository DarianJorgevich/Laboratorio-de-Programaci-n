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
 */
public interface Handler {
    //Cada handler va a estar conectado a otro del mismo tipo con el fin de solucionar el problema
    public void setNext(Handler handler);
    public Handler getNext();
    
    /*
    metodo que verificara si el texto ingresado corresponde a algun idioma
    Si logra reconocerlo lo traduce al español y se muestra por pantalla
    Sino, enviara el texto a otro handler
    */
    public void translateToSp(String text)throws IOException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.patrones.example;

/**
 *
 * @author darian
 */
public interface Handler {
    public void setNext(Handler handler);
    public Handler getNext();
    public void request(int amount);
}

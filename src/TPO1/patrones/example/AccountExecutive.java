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
public class AccountExecutive implements Handler{
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
    public void request(int amount){
        if(amount <= 10000){
            System.out.println("I can handle it, AccountExecutive");
        }else{
            next.request(amount);
        }
    }
}

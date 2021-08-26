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
public class Bank implements Handler{
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
        AccountExecutive executive = new AccountExecutive();
        this.setNext(executive);
        
        TeamLiderExecutive lider = new TeamLiderExecutive();
        executive.setNext(lider);
        
        Manager manager = new Manager();
        lider.setNext(manager);
        
        Director director = new Director();
        manager.setNext(director);
        
        next.request(amount);
    }
}

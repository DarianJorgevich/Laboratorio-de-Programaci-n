/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO1.patrones.example;

/**
 *
 * @author juan
 */
public class main {
    public static void main(String[] args) {
        //Works as client
        Bank bank = new Bank();
        bank.request(12500); //initiates the resolution of the request
    }
}


package patronbridge.preguntas;




public class EjemploPreguntas {

   
    public static void main(String[] args) {
        
        Primario lucas= new Primario ("Lucas", new Geografia());
        Secundario darian= new Secundario ("Darian", new Historia());
        new Trivia(darian).iniciarTrivia();
       
    }
    
}

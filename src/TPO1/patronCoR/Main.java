
package TPO1.patronCoR;

import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
                System.out.println(
                        "Por favor ingrese un monto para retirar (No se admiten numeros reales)");
                int monto = scanner.nextInt();
                if (esValido(monto)) {
                    Cajero.retirar(new PapelMoneda(monto));
                }
            
        }
        
    }
    //si el monto puesto por el usuario es negarivo sera invalido
    private static boolean esValido(int amount) {
        if (amount <= 0) {
            System.out.println("Monto invalido. Intente nuevamente!");
            return false;
        }
        return true;
    }
    
}

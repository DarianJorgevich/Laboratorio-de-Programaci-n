package TPO1.patronCoR;
import java.util.Scanner;

public class PruebaCajero {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println(
                        "Por favor ingrese un monto para retirar (No se admiten numeros reales)");
                int monto = scanner.nextInt();
                if (esValido(monto)) {
                    Cajero.retirar(new PapelMoneda(monto));
                }
            } while (true);
        }
        
    }
    private static boolean esValido(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Try again!");
            return false;
        }
        return true;
    }
}

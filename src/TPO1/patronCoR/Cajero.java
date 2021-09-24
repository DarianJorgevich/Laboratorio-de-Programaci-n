package TPO1.patronCoR;

public class Cajero {
    
    //creamos los manejadores hijos del Manejador padre
    protected static Manejador manejadorQuinientos = new Quinientos();
    protected static Manejador manejadorDocientos = new Docientos();
    protected static Manejador manejadorCien = new Cien();
    protected static Manejador manejadorCincuenta = new Cincuenta();
    protected static Manejador manejadorVeinte = new Veinte();
    protected static Manejador manejadorDiez = new Diez();
    protected static Manejador manejadorCinco = new Cinco();
    protected static Manejador manejadorUno = new Uno();

    //se elige el primer manejador de la cadena
    protected static Manejador primerManejador = manejadorQuinientos;

    static { 
        //construimos la cadena de divisas de mayor a menor denominacion 
        manejadorQuinientos.setManejadorSiguiente(manejadorDocientos);
        manejadorDocientos.setManejadorSiguiente(manejadorCien);
        manejadorCien.setManejadorSiguiente(manejadorCincuenta);
        manejadorCincuenta.setManejadorSiguiente(manejadorVeinte);
        manejadorVeinte.setManejadorSiguiente(manejadorDiez);
        manejadorDiez.setManejadorSiguiente(manejadorCinco);
        manejadorCinco.setManejadorSiguiente(manejadorUno);
    }

    //metodo para retirar dinero del cajero
    public static void retirar(PapelMoneda divisa) {
        if (divisa != null) {
            primerManejador.dispensar(divisa);
        }
    }
}

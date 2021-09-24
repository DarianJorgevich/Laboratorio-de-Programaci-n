package TPO1.patronCoR;

public abstract class Manejador {
    protected Manejador nextDispenser;

    public void setManejadorSiguiente(Manejador nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    public abstract void dispensar(PapelMoneda divisa);
}



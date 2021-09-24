package TPO1.patronCoR;

public abstract class Manejador {
    protected Manejador nextDispenser;

    public void setManejadorSiguiente(Manejador nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    //el metodo dispensar es el que se va a encargar de dar el dinero 
    public abstract void dispensar(PapelMoneda divisa);
}



package TPO1.patronCoR;

public abstract class Manejador {
    protected Manejador nextDispenser;

    public void setNextDispenser(Manejador nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    public abstract void dispensar(PapelMoneda divisa);
}



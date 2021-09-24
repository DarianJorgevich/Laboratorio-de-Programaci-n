package TPO1.patronCoR;

public class PapelMoneda {

    protected int monto;

    public PapelMoneda(int monto) {
        super();
        this.monto = monto;
    }

    public int getAmount() {
        return monto;
    }

    public void setAmount(int monto) {
        this.monto = monto;
    }
}


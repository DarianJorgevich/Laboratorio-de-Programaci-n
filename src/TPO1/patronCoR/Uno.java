package TPO1.patronCoR;

public class Uno extends Manejador {
    
    public Uno(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 1) {
                int cantBilletes = monto / 1;
                vuelto = monto % 1;
                System.out.printf("Dispensing '%d' 1$ currency note.\n", cantBilletes);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}

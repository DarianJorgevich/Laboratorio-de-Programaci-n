package TPO1.patronCoR;

public class Diez extends Manejador {
    
    public Diez(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 10) {
                int cantBilletes = monto / 10;
                vuelto = monto % 10;
                System.out.printf("Dispensing '%d' 10$ currency note.\n", cantBilletes);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}

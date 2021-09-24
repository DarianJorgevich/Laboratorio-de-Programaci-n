package TPO1.patronCoR;

public class Cinco extends Manejador {
    
    public Cinco(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 5) {
                int cantBilletes = monto / 5;
                vuelto = monto % 5;
                System.out.printf("Dispensing '%d' 5$ currency note.\n", cantBilletes);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}

package TPO1.patronCoR;

public class Docientos extends Manejador {
    
    public Docientos(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 200) {
                int cantBilletes = monto / 200;
                vuelto = monto % 200;
                System.out.printf("Dispensing '%d' 200$ currency note.\n", cantBilletes);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}
package TPO1.patronCoR;

public class Cincuenta extends Manejador {
    
    public Cincuenta(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 50) {
                int cantBilletes = monto / 50;
                vuelto = monto % 50;
                System.out.printf("Dispensing '%d' 50$ currency note.\n", cantBilletes);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}
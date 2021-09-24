package TPO1.patronCoR;

public class Cien extends Manejador {
    
    public Cien(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 100) {
                int cantBilletes = monto / 100;
                vuelto = monto % 100;
                System.out.printf("La maquina le da ",cantBilletes, " billetes de '%d' 100$ pesos argentinos.");

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}
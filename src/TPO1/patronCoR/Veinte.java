package TPO1.patronCoR;

public class Veinte extends Manejador {
    
    public Veinte(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 20) {
                int cantBilletes = monto / 20;
                vuelto = monto % 20;
                System.out.printf("La maquina le da ",cantBilletes, "billetes de '%d' 20$ pesos argentinos.");

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}
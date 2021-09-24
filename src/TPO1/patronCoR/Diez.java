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
                System.out.printf("La maquina le da ",cantBilletes, "billetes de '%d' 10$ pesos argentinos.");

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}

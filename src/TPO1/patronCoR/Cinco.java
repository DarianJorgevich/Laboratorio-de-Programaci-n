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
                System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" moneda de 5$\n");
                }
               else{
                   System.out.print(" monedas de 5$\n");
               }

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}

package TPO1.patronCoR;

public class Uno extends Manejador {
    
    public Uno(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getMonto();
            int vuelto = monto;
            if (monto >= 1) {
                int cantBilletes = monto / 1;
                vuelto = monto % 1;
                System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" moneda de 1$\n");
                }
               else{
                   System.out.print(" monedas de 1$\n");
               }

               divisa.setMonto(vuelto);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(divisa);
            }

        }

    }
        
}

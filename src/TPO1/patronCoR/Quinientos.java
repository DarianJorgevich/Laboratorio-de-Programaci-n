package TPO1.patronCoR;

public class Quinientos extends Manejador {
    
    public Quinientos(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
           
            int monto = divisa.getAmount();
            int vuelto = monto;
            if (monto >= 500) {
               int cantBilletes = monto / 500;
               vuelto = monto % 500;
               System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" billete de 500$\n");
                }
               else{
                   System.out.print(" billetes de 500$\n");
               }
            
            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}



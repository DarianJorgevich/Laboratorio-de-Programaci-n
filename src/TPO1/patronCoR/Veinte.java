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
                System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" billete de 20$\n");
                }
               else{
                   System.out.print(" billetes de 20$\n");
               }

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(new PapelMoneda(vuelto));
            }

        }

    }
        
}
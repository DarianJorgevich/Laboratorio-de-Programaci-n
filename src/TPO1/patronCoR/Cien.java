package TPO1.patronCoR;

public class Cien extends Manejador {
    
    public Cien(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getMonto();
            int vuelto = monto;
            if (monto >= 100) {
                int cantBilletes = monto / 100;
                vuelto = monto % 100;
                System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" billete de 100$\n");
                }
               else{
                   System.out.print(" billetes de 100$\n");
               }
               divisa.setMonto(vuelto);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(divisa);
            }
        }

    }
        
}
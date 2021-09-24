package TPO1.patronCoR;

public class Cincuenta extends Manejador {
    
    public Cincuenta(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getMonto();
            int vuelto = monto;
            if (monto >= 50) {
                int cantBilletes = monto / 50;
                vuelto = monto % 50;
                System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" billete de 50$\n");
                }
               else{
                   System.out.print(" billetes de 50$\n");
               }

               divisa.setMonto(vuelto);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(divisa);
            }

        }

    }
        
}
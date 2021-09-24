package TPO1.patronCoR;

public class Diez extends Manejador {
    
    public Diez(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getMonto();
            int vuelto = monto;
            if (monto >= 10) {
                int cantBilletes = monto / 10;
                vuelto = monto % 10;
                System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" billete de 10$\n");
                }
               else{
                   System.out.print(" billetes de 10$\n");
               }

               divisa.setMonto(vuelto);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(divisa);
            }

        }

    }
        
}

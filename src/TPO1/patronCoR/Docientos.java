package TPO1.patronCoR;

public class Docientos extends Manejador {
    
    public Docientos(){
        super();
    }

    
    @Override
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
            int monto = divisa.getMonto();
            int vuelto = monto;
            if (monto >= 200) {
                int cantBilletes = monto / 200;
                vuelto = monto % 200;
                System.out.print("La maquina le da " +cantBilletes);
               
               if(cantBilletes==1){
                   System.out.print(" billete de 200$\n");
                }
               else{
                   System.out.print(" billetes de 200$\n");
               }
               divisa.setMonto(vuelto);

            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(divisa);
            }

        }

    }
        
}
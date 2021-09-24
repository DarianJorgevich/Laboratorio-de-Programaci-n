package TPO1.patronCoR;

public class Quinientos extends Manejador {
    
    public Quinientos(){
        super();
    }

    
    @Override
    /*
    El metodo dispensar se encargara de:
     - Segun la cantidad de dinero que le llegue (divisa) vera si la puede fraccionar en 500
     - Si puede, dara la cantidad de billetes de 500 pesos que le corresponde a la maquina
        - En este caso el resto de la division sera el nuevo monto de la divisa y se lo envia al siguiente manejador 
     - Si no puede fraccionar en 500 pesos, envia la divisa al siguiente manejador
     -
    */
    public void dispensar(PapelMoneda divisa) {
        if (divisa != null) {
           
            int monto = divisa.getMonto();
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
               divisa.setMonto(vuelto);
            
            }
            if (vuelto > 0 && this.nextDispenser != null) {
                this.nextDispenser.dispensar(divisa);
            }

        }

    }
        
}



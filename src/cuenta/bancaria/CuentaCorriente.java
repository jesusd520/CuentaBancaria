package cuenta.bancaria;

public class CuentaCorriente extends Cuenta {
    
    protected float sobregiro;
    
    public CuentaCorriente(float saldo, float tasaAnual) {
        sobregiro = 0;
        super(saldo, tasaAnual);        
    }
    @Override
    public void consignar(float cantidad){
        if (sobregiro>0 ) {
            float restante = cantidad - sobregiro;
            
            if (restante > 0) {
                sobregiro = 0;
                saldo = restante;
                numConsignaciones += 1;
                System.out.println("Se abono $" + String.format("%,.2f", sobregiro) +" de saldo pendiente y se añadieron $" + String.format("%,.2f", restante) + " a su cuenta");
            }            
            else if (restante == 0){
                sobregiro = sobregiro - cantidad;
                saldo = 0;
                numConsignaciones += 1;
                System.out.println("Su deuda de $" + String.format("%,.2f", sobregiro) +" ha sido pagada");
            }
            else {
                sobregiro = sobregiro - cantidad;
                saldo = 0;
                numConsignaciones += 1;
                System.out.println("Se abono $" + String.format("%,.2f", cantidad) + " a su deuda");
            }
        }
        else {
            super.consignar(cantidad);
        }   
    }
    @Override
    public void retirar(float cantidad){
        if (cantidad > saldo){
            float faltante = cantidad - saldo;
            saldo = 0;
            sobregiro = sobregiro + faltante;
            numRetiros += 1;
            System.out.println("Retiro exitoso. Ahora su deuda es de: $" + String.format("%,.2f", sobregiro));
        }
        else {
            super.retirar(cantidad);      
        }
    }
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }
    public void imprimir3(){
        int numTransacciones = numConsignaciones + numRetiros;
        System.out.println("Saldo: $" + String.format("%,.2f", saldo));
        System.out.println("Comision mensual: $" + String.format("%,.2f", comMensual));
        System.out.println("Numero de transacciones: " + numTransacciones);
        System.out.println("Sobregiro: $" + String.format("%,.2f", sobregiro));
    }   
}

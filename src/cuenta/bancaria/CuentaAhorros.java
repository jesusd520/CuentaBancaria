package cuenta.bancaria;

public class CuentaAhorros extends Cuenta {
    private boolean activa;
    
    
    public CuentaAhorros(float saldo, float tasaAnual){
        super(saldo, tasaAnual);
        if (saldo < 10000){
            activa = false;
        }
        else {
            activa = true;
        }
    }
    @Override
    public void consignar(float cantidad){
        if(activa){
        super.consignar(cantidad);
        }
        else{
            System.out.println("Esta accion no se pudo realizar. La cuenta esta inactiva");}
    }
    @Override
    public void retirar(float cantidad) {
        if(activa){
        super.retirar(cantidad);       
        }
        else{
            System.out.println("Esta accion no se pudo realizar. La cuenta esta inactiva");}
    }
    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            int excesoRetiros = (numRetiros-4);
            saldo = saldo - (excesoRetiros*1000);
        }
        super.extractoMensual();
        
        if (saldo < 10000){
            activa = false;
        }        
    }   
    public void imprimir2() {
        if (activa == true){
            System.out.println("Estado: Activa");}
        else {
            System.out.println("Estadoinactiva");
        }
        int numTransacciones = numConsignaciones + numRetiros;
        System.out.println("Saldo: $" + String.format("%,.2f", saldo));
        System.out.println("Comision mensual: $" + String.format("%,.2f", comMensual));
        System.out.println("Numero de transacciones: " + numTransacciones);       
    }
}
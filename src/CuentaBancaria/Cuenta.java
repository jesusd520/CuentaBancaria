
package CuentaBancaria;

public class Cuenta {
    protected float saldo;
    protected int numConsignaciones = 0;
    protected int numRetiros = 0;
    protected float tasaAnual; // Expresada de la forma x%. Ej: 24 -> 24%
    protected float comMensual = 0; // Expresada en moneda COP
        
    public Cuenta(float saldo, float tasaAnual){
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }
    public void consignar(float cantidad) {
        if (cantidad > 0){
            saldo = saldo + cantidad;
            numConsignaciones += 1;
            System.out.println("Cosignacion exitosa. Su nuevo saldo es de: $" + String.format("%,.2f", saldo)); 
        }
        else {
            System.out.println("La cantidad a consignar debe ser mayor a cero");
        }
    }    
    public void retirar(float cantidad) {
        if ((cantidad > 0) && (cantidad <= saldo)){
            saldo = saldo - cantidad;
            numRetiros += 1;
            System.out.println("Retiro exitoso. Su nuevo saldo es de: $" + String.format("%,.2f", saldo));
        }
        else {
            System.out.println("La cantidad a retirar debe ser mayor que cero y no puede superar el saldo actual. Recuerde que su saldo es de: $" + String.format("%,.2f", saldo));
        }
    }
    public float aplicarIntMensual(){
        float tasaMensual = tasaAnual/12;
        float interesAplicado = saldo*(tasaMensual/100);
        saldo = saldo + interesAplicado;
        System.out.println("Interes de " + tasaMensual +"% aplicado. Su nuevo saldo es de: $" + String.format("%,.2f", saldo)); 
        return interesAplicado;
    }
    public void extractoMensual() {
        
        saldo = saldo - comMensual;
        float interesEsteMes = aplicarIntMensual();
        System.out.println("Este mes genero un interes de $" + String.format("%,.2f", interesEsteMes) + " y se le resto una comision de $" + String.format("%,.2f", comMensual) + ". Su saldo actual es de: $" + String.format("%,.2f", saldo));
    }
    public void imprimir() {
        System.out.println("Saldo: $" + String.format("%,.2f", saldo));
        System.out.println("Numero de consignaciones: " + numConsignaciones);
        System.out.println("Numero de retiros: " + numRetiros);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comision mensual: $" + String.format("%,.2f", comMensual));
    }   
}



package punto4y5;

public class Main {
    public static void main(String[] args) {
        CuentaNormal cuentaNormal = new CuentaNormal(1000, 500);
        CuentaCredito cuentaCredito = new CuentaCredito(2000, 1000, 1500);

        cuentaNormal.invertir(300);

        cuentaNormal.cancelarInversion();

        cuentaCredito.realizarCompra(800);

        if (!cuentaCredito.puedePrecancelar(1000)) {
            cuentaCredito.precancelarInversion();
        }

        System.out.println("Cuenta Normal:");
        System.out.println("Saldo: " + cuentaNormal.getSaldo());
        System.out.println("Monto invertido: " + cuentaNormal.getInversion());

        System.out.println("\nCuenta de Crédito:");
        System.out.println("Saldo: " + cuentaCredito.getSaldo());
        System.out.println("Límite de compra: " + cuentaCredito.getLimiteCompra());
        System.out.println("Saldo Deudor: " + cuentaCredito.getSaldoDeudor());
    }
}


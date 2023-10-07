package punto4y5;
import java.time.LocalDate;

public class CuentaCredito extends Cuenta {
    private double limiteCompra;
    private double intereses;
    private LocalDate fechaUltimaCompra;

    public CuentaCredito(double saldoInicial, double limiteGiro, double limiteCompra) {
        super(saldoInicial, limiteGiro);
        this.limiteCompra = limiteCompra;
        this.intereses = 0.0;
        this.fechaUltimaCompra = null;
    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
        limiteCompra += monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo + limiteGiro) {
            saldo -= monto;
        } else {
            System.out.println("No se puede realizar el retiro. Saldo insuficiente.");
        }
    }

    @Override
    public void invertir(double monto) {
        System.out.println("No se puede invertir en una cuenta de crédito.");
    }

    public void realizarCompra(double monto) {
        double saldoDisponible = getSaldoDisponible();
        if (monto <= saldoDisponible) {
            saldo -= monto * 1.05;
            limiteCompra -= monto;
            intereses += monto * 0.05;
            fechaUltimaCompra = LocalDate.now();
        } else {
            System.out.println("No se puede realizar la compra. Saldo disponible insuficiente.");
        }
    }

    public void realizarPago(double monto) {
        if (monto <= intereses) {
            intereses -= monto;
            limiteCompra += monto;
        } else {
            System.out.println("No se puede realizar el pago. Monto insuficiente.");
        }
    }

    public double getSaldoDeudor() {
        return intereses;
    }

    private double getSaldoDisponible() {
        double saldoDisponible = saldo;
        if (inversion > 0) {
            saldoDisponible += inversion;
        }
        return saldoDisponible;
    }

    public void precancelarInversion() {
        if (inversion > 0) {
            saldo += inversion;
            inversion = 0.0;
        }
    }

    public boolean puedePrecancelar(double monto) {
        if (inversion > 0) {
            LocalDate fechaActual = LocalDate.now();
            long diasTranscurridos = fechaUltimaCompra.until(fechaActual).getDays();
            return monto <= saldo + inversion || diasTranscurridos < 30;
        }
        return true;
    }

    public double getLimiteCompra(){
        return limiteCompra;
    }
}
package punto4y5;
import java.time.LocalDate;

public class CuentaNormal extends Cuenta {
    private boolean invirtiendo;
    private LocalDate fechaUltimaInversion;

    public CuentaNormal(double saldoInicial, double limiteGiro) {
        super(saldoInicial, limiteGiro);
        this.invirtiendo = false;
        this.fechaUltimaInversion = null;
    }

    @Override
    public void depositar(double monto) {
        saldo += monto;
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
        if (!invirtiendo) {
            inversion += monto;
            invirtiendo = true;
            fechaUltimaInversion = LocalDate.now();
        } else {
            System.out.println("Ya tiene una inversión en curso. Espere a que finalice.");
        }
    }

    public void cancelarInversion() {
        if (invirtiendo) {
            LocalDate fechaActual = LocalDate.now();
            long diasTranscurridos = fechaUltimaInversion.until(fechaActual).getDays();

            if (diasTranscurridos >= 30) {
                saldo += inversion * 1.05; // Aplicar interés del 5%
            } else {
                saldo += inversion;
            }

            inversion = 0.0;
            invirtiendo = false;
            fechaUltimaInversion = null;
        } else {
            System.out.println("No hay inversión en curso.");
        }
    }

    public boolean puedePrecancelar(double monto) {
        if (invirtiendo) {
            LocalDate fechaActual = LocalDate.now();
            long diasTranscurridos = fechaUltimaInversion.until(fechaActual).getDays();
            return monto <= saldo + inversion || diasTranscurridos < 30;
        }
        return true;
    }
}

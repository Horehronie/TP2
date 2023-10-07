package punto4y5;
public abstract class Cuenta {
    protected double saldo;
    protected double limiteGiro;
    protected double inversion;

    public Cuenta(double saldoInicial, double limiteGiro) {
        this.saldo = saldoInicial;
        this.limiteGiro = limiteGiro;
        this.inversion = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteGiro() {
        return limiteGiro;
    }

    public double getInversion() {
        return inversion;
    }

    public abstract void depositar(double monto);
    public abstract void retirar(double monto);
    public abstract void invertir(double monto);
}


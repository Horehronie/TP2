package punto10;

public class EmpleadoAsalariado extends Empleado {
    private double sueldoMensual;

    public EmpleadoAsalariado(String nombre, String apellido, String telefono, String CUIT, double sueldoMensual) {
        super(nombre, apellido, telefono, CUIT);
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public double calcularSueldo() {
        return sueldoMensual + calcularBonoCumpleaños() + 1000.0; // Bono de cumpleaños para asalariados
    }
}

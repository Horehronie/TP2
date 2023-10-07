package punto10;

public class EmpleadoComisionConSalarioBase extends EmpleadoComision {
    private double baseSalario;

    public EmpleadoComisionConSalarioBase(String nombre, String apellido, String telefono, String CUIT, double ventasRealizadas, double porcentajeComision, double baseSalario) {
        super(nombre, apellido, telefono, CUIT, ventasRealizadas, porcentajeComision);
        this.baseSalario = baseSalario;
    }

    @Override
    public double calcularSueldo() {
        return super.calcularSueldo() + baseSalario + 1000.0; // Bono de cumpleaños para empleados con salario base
    }
}

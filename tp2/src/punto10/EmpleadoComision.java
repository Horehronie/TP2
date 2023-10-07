package punto10;

public class EmpleadoComision extends Empleado {
    private double ventasRealizadas;
    private double porcentajeComision;

    public EmpleadoComision(String nombre, String apellido, String telefono, String CUIT, double ventasRealizadas, double porcentajeComision) {
        super(nombre, apellido, telefono, CUIT);
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSueldo() {
        return ventasRealizadas * (porcentajeComision / 100.0) + calcularBonoCumpleaños();
    }
}

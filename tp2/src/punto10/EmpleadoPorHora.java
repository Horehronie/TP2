package punto10;

public class EmpleadoPorHora extends Empleado {
    private int horasTrabajadas;
    private double salarioPorHora;

    public EmpleadoPorHora(String nombre, String apellido, String telefono, String CUIT, int horasTrabajadas, double salarioPorHora) {
        super(nombre, apellido, telefono, CUIT);
        this.horasTrabajadas = horasTrabajadas;
        this.salarioPorHora = salarioPorHora;
    }

    @Override
    public double calcularSueldo() {
        double sueldo = horasTrabajadas * salarioPorHora;

        // Verificar si se superan las 40 horas
        if (horasTrabajadas > 40) {
            sueldo += (sueldo * 0.2); // 20% de bono por horas extra
        }

        return sueldo + calcularBonoCumpleaños();
    }
}

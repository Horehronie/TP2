package punto10;

public class Pasante extends Empleado {
    public Pasante(String nombre, String apellido, String telefono, String CUIT) {
        super(nombre, apellido, telefono, CUIT);
    }

    @Override
    public double calcularSueldo() {
        return 0.0; // Los pasantes no reciben salario
    }
}

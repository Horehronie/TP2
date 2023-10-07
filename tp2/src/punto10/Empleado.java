package punto10;

import java.util.Calendar;
import java.util.Date;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private String telefono;
    private String CUIT;

    public Empleado(String nombre, String apellido, String telefono, String CUIT) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.CUIT = CUIT;
    }

    public abstract double calcularSueldo();

    // Método para calcular el bono de cumpleaños
    public double calcularBonoCumpleaños() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int mesActual = calendar.get(Calendar.MONTH);

        if (mesActual == Calendar.JANUARY) {  // Cumpleaños en enero
            return 2000.0;
        } else {
            return 0.0;
        }
    }
}

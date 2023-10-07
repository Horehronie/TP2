package punto10;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Ejemplos de empleados
        Empleado asalariado = new EmpleadoAsalariado("Juan", "Perez", "123-456-789", "1234567890", 5000.0);
        Empleado comision = new EmpleadoComision("Maria", "Gonzalez", "987-654-321", "0987654321", 10000.0, 2.5);
        Empleado comisionConSalarioBase = new EmpleadoComisionConSalarioBase("Carlos", "Lopez", "555-555-555", "5555555555", 8000.0, 3.0, 2000.0);
        Empleado porHora = new EmpleadoPorHora("Laura", "Sanchez", "222-222-222", "2222222222", 45, 10.0);
        Empleado pasante = new Pasante("Lucia", "Rodriguez", "111-111-111", "1111111111");

        // Calcular el sueldo de cada empleado
        System.out.println("Sueldo de asalariado: $" + asalariado.calcularSueldo());
        System.out.println("Sueldo de comision: $" + comision.calcularSueldo());
        System.out.println("Sueldo de comision con salario base: $" + comisionConSalarioBase.calcularSueldo());
        System.out.println("Sueldo de por hora: $" + porHora.calcularSueldo());
        System.out.println("Sueldo de pasante: $" + pasante.calcularSueldo());
    }
}
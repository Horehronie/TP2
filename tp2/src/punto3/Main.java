package punto3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String correo;

    public Persona(String nombre, String apellido, String direccion, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y setters
}

class Alumno extends Persona {
    private int idEstudiante;
    private List<Diagramacion> inscripciones;
    private String credencial;

    public Alumno(String nombre, String apellido, String direccion, String telefono, String correo, int idEstudiante) {
        super(nombre, apellido, direccion, telefono, correo);
        this.idEstudiante = idEstudiante;
        this.inscripciones = new ArrayList<>();
        this.credencial = "CRED-" + idEstudiante;
    }

    public void inscribirseEnDiagramacion(Diagramacion diagramacion) {
        inscripciones.add(diagramacion);
    }

    public String getCredencial() {
        return credencial;
    }

    // Otros métodos
}

class Profesor extends Persona {
    private int idProfesor;
    private List<Clase> clases;

    public Profesor(String nombre, String apellido, String direccion, String telefono, String correo, int idProfesor) {
        super(nombre, apellido, direccion, telefono, correo);
        this.idProfesor = idProfesor;
        this.clases = new ArrayList<>();
    }

    public void asignarClase(Clase clase) {
        clases.add(clase);
    }

    public double calcularPagoMensual() {
        int totalAsistencias = 0;
        for (Clase clase : clases) {
            totalAsistencias += clase.getAsistencia().size();
        }
        return totalAsistencias * 10.0; // Cada día de asistencia paga $10 al profesor
    }

    public List<Clase> getClases(){
        return clases;
    }
}

class Diagramacion {
    private String dia;
    private String horario;
    private String nivel;
    private String disciplina;
    private Profesor profesor;
    private String salon;

    public Diagramacion(String dia, String horario, String nivel, String disciplina, Profesor profesor, String salon) {
        this.dia = dia;
        this.horario = horario;
        this.nivel = nivel;
        this.disciplina = disciplina;
        this.profesor = profesor;
        this.salon = salon;
    }

    public double calcularIngresosMensuales() {
        double ingresos = 0;
        for (Clase clase : profesor.getClases()) {
            if (clase.getDiagramacion() == this) {
                ingresos += clase.getAsistencia().size() * 10.0;
            }
        }
        return ingresos;
    }

    public String getDisciplina(){
        return disciplina;
    }
}

class Clase {
    private Date fecha;
    private List<Alumno> asistencia;
    private Diagramacion diagramacion;

    public Clase(Date fecha, Diagramacion diagramacion) {
        this.fecha = fecha;
        this.diagramacion = diagramacion;
        this.asistencia = new ArrayList<>();
    }

    public void registrarAsistencia(Alumno alumno) {
        asistencia.add(alumno);
    }

    public List<Alumno> getAsistencia() {
        return asistencia;
    }

    public Diagramacion getDiagramacion() {
        return diagramacion;
    }

    // Otros métodos
}

class Salon {
    private String nombre;
    private int capacidad;

    public Salon(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    // Otros métodos
}

class Academia {
    private List<Alumno> alumnos;
    private List<Profesor> profesores;
    private List<Diagramacion> diagramaciones;
    private List<Salon> salones;

    public Academia() {
        this.alumnos = new ArrayList<>();
        this.profesores = new ArrayList<>();
        this.diagramaciones = new ArrayList<>();
        this.salones = new ArrayList<>();
    }

    public void generarReporteIngresosPorDisciplina() {
        String disciplinaMayorIngreso = "";
        double mayorIngreso = 0;

        for (Diagramacion diagramacion : diagramaciones) {
            double ingresos = diagramacion.calcularIngresosMensuales();
            if (ingresos > mayorIngreso) {
                mayorIngreso = ingresos;
                disciplinaMayorIngreso = diagramacion.getDisciplina();
            }
        }

        System.out.println("La disciplina que genera mayor ingreso es: " + disciplinaMayorIngreso);
    }

    // Otros métodos
}

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso del sistema
        Academia academia = new Academia();

        Profesor profesor1 = new Profesor("Juan", "Perez", "Dirección 1", "123456789", "juan@example.com", 1);
        Profesor profesor2 = new Profesor("Maria", "Lopez", "Dirección 2", "987654321", "maria@example.com", 2);

        Diagramacion diagramacion1 = new Diagramacion("Lunes", "10:00 AM", "Inicial", "Tango", profesor1, "Salón A");
        Diagramacion diagramacion2 = new Diagramacion("Martes", "11:00 AM", "Intermedio", "Tango", profesor1, "Salón B");

        Alumno alumno1 = new Alumno("Carlos", "Gomez", "Dirección 3", "555555555", "carlos@example.com", 101);
        Alumno alumno2 = new Alumno("Ana", "Rodriguez", "Dirección 4", "666666666", "ana@example.com", 102);

        Clase clase1 = new Clase(new Date(), diagramacion1);
        clase1.registrarAsistencia(alumno1);
        clase1.registrarAsistencia(alumno2);

        profesor1.asignarClase(clase1);

        alumno1.inscribirseEnDiagramacion(diagramacion1);
        alumno2.inscribirseEnDiagramacion(diagramacion2);

        double pagoProfesor1 = profesor1.calcularPagoMensual();
        double pagoProfesor2 = profesor2.calcularPagoMensual();

        System.out.println("Pago mensual del profesor 1: $" + pagoProfesor1);
        System.out.println("Pago mensual del profesor 2: $" + pagoProfesor2);

        academia.generarReporteIngresosPorDisciplina();
    }
}
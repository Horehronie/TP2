package punto1;

import java.time.LocalDate;

public class Socio {
    private String nombre;
    private String email;
    private String direccion;
    private LocalDate fechaInscripcion;
    private Suscripcion tipoDeSuscripcion;

    public Socio(String nombre, String email, String direccion, String fechaInscripcion, String tipoDeSuscripcion){
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        switch(tipoDeSuscripcion.toLowerCase()){
            case "basica":
                this.tipoDeSuscripcion = new Basica();
                break;
            case "intermedia":
                this.tipoDeSuscripcion = new Intermedia();
                break;
            case "destacada":
                this.tipoDeSuscripcion = new Destacada();
                break;
            default:
                System.out.println("Tipo de suscripcion invalida");
                this.tipoDeSuscripcion = null;
                break;
        }
        this.fechaInscripcion = LocalDate.parse(fechaInscripcion);
    }

    public String getCredencial(){
        return "Nombre: " + nombre + "\nEmail: " + email + "\nDireccion: " + direccion +
                "\nFecha de Inscripcion: " + fechaInscripcion.toString() + "\nTipo de Suscripcion: " +
                tipoDeSuscripcion.getTipoDeSuscripcion();
    }

    public LocalDate getFechaInscripcion(){
        return fechaInscripcion;
    }

    public String getNombre(){
        return nombre;
    }
    public String getEmail(){
        return email;
    }
    public String getDireccion(){
        return direccion;
    }
    public Suscripcion getSuscripcion(){
        return tipoDeSuscripcion;
    }

}

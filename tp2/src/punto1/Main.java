package punto1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.jar.Attributes;

public class Main {
    public static void main(String[] args) {

        ArrayList<Socio> listaDeSocios = new ArrayList<>();
        Socio socio1 = new Socio("Facundo Mazzaglia", "facundo@gmail.com", "hola 123",
                        "2023-09-25", "basica");
        Socio socio2 = new Socio("Selena Gomez", "hola@gmail.com", "hola 250",
                        "2023-09-24", "basica");
        Socio socio3 = new Socio("Justin Bieber", "mail@gmail.com", "hola 390",
                        "2023-08-25", "intermedia");
        Socio socio4 = new Socio("Maria Becerra", "nose@gmail.com", "hola 222",
                        "2023-08-25", "destacada");

        listaDeSocios.add(socio1);
        listaDeSocios.add(socio2);
        listaDeSocios.add(socio3);
        listaDeSocios.add(socio4);

        Scanner scanOpcion = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {
            opcion = 0;
            while (opcion < 1 || opcion > 5) {
                System.out.println("Elija una opcion: \n" +
                        "1: Ver inscriptos de un mes\n" +
                        "2: Ver actividades por suscripcion\n" +
                        "3: Ver listado de socios por suscripcion\n" +
                        "4: Agregar socios\n" +
                        "5: Salir");
                opcion = scanOpcion.nextInt();
                if (opcion < 1 || opcion > 5) System.out.println("Ingrese una opcion valida.");
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el numero de mes al que quiere acceder: ");
                    int mes = 13;
                    while (mes > 12 || mes < 1) {
                        Scanner scan = new Scanner(System.in);
                        mes = scan.nextInt();
                        if (mes > 12 || mes < 1) System.out.println("Ingrese un mes valido: ");
                    }
                    LocalDate fechaParaUtilizarElMes = LocalDate.of(2000, mes, 15);
                    System.out.println("Inscriptos del mes seleccionado: ");
                    for (Socio s : listaDeSocios) {
                        if (s.getFechaInscripcion().getMonth() == fechaParaUtilizarElMes.getMonth()) {
                            System.out.println(s.getCredencial() + "\n");
                        }
                    }
                    break;
                case 2:
                    Suscripcion sus = new Basica();
                    System.out.println("Actividades de la suscripcion basica: " + sus.getActividades());
                    sus = new Intermedia();
                    System.out.println("Actividades de la suscripcion intermedia: " + sus.getActividades());
                    sus = new Destacada();
                    System.out.println("Actividades de la suscripcion destacada: " + sus.getActividades());
                    break;
                case 3:
                    System.out.println("Ingrese la suscripcion a la que quiere acceder: ");
                    String sub = "";
                    while (!(sub.equalsIgnoreCase("basica") || sub.equalsIgnoreCase("intermedia")
                            || sub.equalsIgnoreCase("destacada"))) {
                        Scanner scan = new Scanner(System.in);
                        sub = scan.nextLine();
                        if (!(sub.equalsIgnoreCase("basica") || sub.equalsIgnoreCase("intermedia")
                                || sub.equalsIgnoreCase("destacada"))) {
                            System.out.println("Ingrese una suscripcion valida: ");
                        }
                    }
                    System.out.println("Inscriptos de con suscripcion " + sub + ": ");
                    for (Socio s : listaDeSocios) {
                        if (sub.equalsIgnoreCase(s.getSuscripcion().getTipoDeSuscripcion())) {
                            System.out.println(s.getCredencial() + "\n");
                        }
                    }
                    break;
                case 4:
                    listaDeSocios.addAll(getSocios());
                    break;
                case 5:
                default:
                    break;
            }

            System.out.println("Enter para continuar...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
    }
}


    private static ArrayList<Socio> getSocios () {
            Socio socio;
            ArrayList<Socio> listaDeSocios = new ArrayList<>();
            Boolean continua = true;
            Scanner scan = new Scanner(System.in);
            String nombre, email, direccion, fechaDeInscripcion, suscripcion, c;
            while (continua) {
                System.out.println("Ingrese el nombre del socio: ");
                nombre = scan.nextLine();
                System.out.println("Ingrese el email del socio: ");
                email = scan.nextLine();
                System.out.println("Ingrese la direccion del socio: ");
                direccion = scan.nextLine();
                System.out.println("Ingrese la fecha de inscripcion del socio(AAAA-MM-DD): ");
                fechaDeInscripcion = scan.nextLine();
                System.out.println("Ingrese el tipo de suscripcion(basica-intermedia-destacada: ");
                suscripcion = scan.nextLine();
                socio = new Socio(nombre, email, direccion, fechaDeInscripcion, suscripcion);
                listaDeSocios.add(socio);
                System.out.println("Desea agregar otro socio?(no/otro)");
                c = scan.nextLine();
                if (c.equalsIgnoreCase("no")) continua = false;
            }

            return listaDeSocios;
        }
    }


package punto2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Proveedor {
    private String nombre;
    private String tipo;

    public Proveedor(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

}

class Transporte extends Proveedor {
    public Transporte(String nombre) {
        super(nombre, "Transporte");
    }
}

class Hospedaje extends Proveedor {
    public Hospedaje(String nombre) {
        super(nombre, "Hospedaje");
    }
}

class Excursion extends Proveedor {
    public Excursion(String nombre) {
        super(nombre, "Excursión");
    }
}

class PaqueteTurismo {
    private String destino;
    private Proveedor transporte;
    private Proveedor hospedaje;
    private List<Proveedor> excursiones;

    public PaqueteTurismo(String destino, Proveedor transporte, Proveedor hospedaje) {
        this.destino = destino;
        this.transporte = transporte;
        this.hospedaje = hospedaje;
        this.excursiones = new ArrayList<>();
    }

    public void agregarExcursion(Proveedor excursion) {
        excursiones.add(excursion);
    }

    public String getDestino(){
        return destino;
    }

}

class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

}

class Venta {
    private Cliente cliente;
    private PaqueteTurismo paquete;

    public Venta(Cliente cliente, PaqueteTurismo paquete) {
        this.cliente = cliente;
        this.paquete = paquete;
    }

    public PaqueteTurismo getPaquete(){
        return paquete;
    }
}

public class SunBeach {
    public static void main(String[] args) {
        Transporte transporte1 = new Transporte("Aerolínea XYZ");
        Hospedaje hospedaje1 = new Hospedaje("Hotel ABC");
        Excursion excursion1 = new Excursion("Excursión 123");

        PaqueteTurismo paquete1 = new PaqueteTurismo("Playa paradisíaca", transporte1, hospedaje1);
        paquete1.agregarExcursion(excursion1);

        Cliente cliente1 = new Cliente("Cliente 1");

        Venta venta1 = new Venta(cliente1, paquete1);

        Map<String, Venta> ventas = new HashMap<>();
        ventas.put("Venta1", venta1);

        Map<String, Integer> ventasPorDestino = new HashMap<>();
        for (Venta venta : ventas.values()) {
            String destino = venta.getPaquete().getDestino();
            ventasPorDestino.put(destino, ventasPorDestino.getOrDefault(destino, 0) + 1);
        }

        System.out.println("Informe de ventas por destino:");
        for (Map.Entry<String, Integer> entry : ventasPorDestino.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ventas");
        }

        String destinoFavorito = "";
        int maxVentas = 0;
        for (Map.Entry<String, Integer> entry : ventasPorDestino.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                destinoFavorito = entry.getKey();
            }
        }

        System.out.println("El destino favorito de los clientes es: " + destinoFavorito);
    }
}
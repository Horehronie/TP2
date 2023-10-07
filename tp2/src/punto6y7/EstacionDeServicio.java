package punto6y7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Cliente {
    private String nombre;
    private double totalCompras;
    private boolean top10;
    private double descuento;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.totalCompras = 0.0;
        this.top10 = false;
        this.descuento = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

    public boolean esTop10() {
        return top10;
    }

    public void setTop10(boolean top10) {
        this.top10 = top10;
    }

    public void agregarCompra(double monto) {
        this.totalCompras += monto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void aplicarDescuento(double descuento) {
        this.descuento += descuento;
    }
}

class Empleado {
    private String nombre;
    private double totalVentas;
    private boolean top10;
    private boolean descuentoUtilizado;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.totalVentas = 0.0;
        this.top10 = false;
        this.descuentoUtilizado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public boolean esTop10() {
        return top10;
    }

    public void setTop10(boolean top10) {
        this.top10 = top10;
    }

    public boolean isDescuentoUtilizado() {
        return descuentoUtilizado;
    }

    public void aplicarDescuentoCliente(Cliente cliente) {
        if (!descuentoUtilizado && top10) {
            double descuento = cliente.getTotalCompras() * 0.10;
            cliente.aplicarDescuento(descuento);
            descuentoUtilizado = true;
        }
    }

    public void registrarVenta(double monto) {
        this.totalVentas += monto;
    }
}

class Surtidor {
    private String tipoCombustible;
    private double precioActual;

    public Surtidor(String tipoCombustible, double precioInicial) {
        this.tipoCombustible = tipoCombustible;
        this.precioActual = precioInicial;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void cambiarPrecio(double nuevoPrecio) {
        precioActual = nuevoPrecio;
    }
}

class Venta {
    private String numeroPatente;
    private String tipoCombustible;
    private double totalVenta;
    private Empleado empleado;
    private Cliente cliente;
    private double precioCombustible;

    public Venta(String numeroPatente, String tipoCombustible, double totalVenta, Empleado empleado, Cliente cliente, double precioCombustible) {
        this.numeroPatente = numeroPatente;
        this.tipoCombustible = tipoCombustible;
        this.totalVenta = totalVenta;
        this.empleado = empleado;
        this.cliente = cliente;
        this.precioCombustible = precioCombustible;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public double getPrecioCombustible() {
        return precioCombustible;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalVentaConDescuento() {
        double descuento = 0.0;
        if (cliente != null && cliente.esTop10()) {
            descuento = totalVenta * 0.05;
        }
        return totalVenta - descuento;
    }
}

public class EstacionDeServicio {
    public static void main(String[] args) {
        // Crear empleados
        Empleado empleado1 = new Empleado("Empleado 1");
        Empleado empleado2 = new Empleado("Empleado 2");

        // Crear clientes
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");

        // Configurar top 10
        cliente1.setTop10(true);
        cliente2.setTop10(true);

        // Crear surtidores
        Surtidor surtidorNafta = new Surtidor("Nafta", 2.0);
        Surtidor surtidorGasoil = new Surtidor("Gasoil", 1.5);

        // Realizar ventas
        Venta venta1 = new Venta("ABC123", "Nafta", 50.0, empleado1, cliente1, surtidorNafta.getPrecioActual());
        Venta venta2 = new Venta("XYZ789", "Gasoil", 40.0, empleado2, cliente2, surtidorGasoil.getPrecioActual());

        empleado1.registrarVenta(venta1.getTotalVentaConDescuento());
        empleado2.registrarVenta(venta2.getTotalVentaConDescuento());

        surtidorNafta.cambiarPrecio(2.5); // Cambiar precio de Nafta
        surtidorGasoil.cambiarPrecio(1.8); // Cambiar precio de Gasoil

        // Generar informes
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);

        List<Surtidor> surtidores = new ArrayList<>();
        surtidores.add(surtidorNafta);
        surtidores.add(surtidorGasoil);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        // Listado de empleados ordenado por monto total de ventas
        Collections.sort(empleados, Comparator.comparing(Empleado::getTotalVentas).reversed());
        for (Empleado empleado : empleados) {
            System.out.println("Empleado: " + empleado.getNombre() +
                    ", Monto Total de Ventas: " + empleado.getTotalVentas());
        }

        // Listado de surtidores ordenado por precio actual
        Collections.sort(surtidores, Comparator.comparing(Surtidor::getPrecioActual));
        for (Surtidor surtidor : surtidores) {
            System.out.println("Tipo de Combustible: " + surtidor.getTipoCombustible() +
                    ", Precio Actual: " + surtidor.getPrecioActual());
        }
    }
}




package logica;

import java.util.Date;
import javax.persistence.ManyToOne;
import logica.entidades.Cliente;
import logica.entidades.Empleado;

public class Venta {
    
    private int numVenta;
    private Date fechaVenta;
    private String medioPago;
    @ManyToOne
    private PaqueteTuristico paqueteTuristico;
    @ManyToOne
    private Servicio servicio;
    @ManyToOne
    private Empleado empleado;
    @ManyToOne
    private Cliente cliente;

    public Venta() {
    }

    public Venta(int numVenta, Date fechaVenta, String medioPago, PaqueteTuristico paqueteTuristico, Servicio servicio, Empleado empleado, Cliente cliente) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
        this.paqueteTuristico = paqueteTuristico;
        this.servicio = servicio;
        this.empleado = empleado;
        this.cliente = cliente;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public PaqueteTuristico getPaqueteTuristico() {
        return paqueteTuristico;
    }

    public void setPaqueteTuristico(PaqueteTuristico paqueteTuristico) {
        this.paqueteTuristico = paqueteTuristico;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}

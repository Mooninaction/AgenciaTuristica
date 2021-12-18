package logica.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import logica.Venta;

@Entity
public class Cliente extends Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCliente;
    @OneToMany
    private Empleado empleado;
    @OneToOne
    private Venta venta;

    public Cliente() {
    }

    public Cliente(int idCliente, Empleado empleado, Venta venta) {
        this.idCliente = idCliente;
        this.empleado = empleado;
        this.venta = venta;
    }

    public Cliente(int idCliente, Empleado empleado, Venta venta, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email) {
        super(nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.idCliente = idCliente;
        this.empleado = empleado;
        this.venta = venta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", empleado=" + empleado + ", venta=" + venta + '}';
    }

}

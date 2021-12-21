package logica.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import logica.Venta;

@Entity
public class Cliente extends Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCliente;
    @OneToOne
    private Venta venta;

    public Cliente() {
    }

    public Cliente(int idCliente, Venta venta) {
        this.idCliente = idCliente;
        this.venta = venta;
    }

    public Cliente(int idCliente, Venta venta, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email) {
        super(nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.idCliente = idCliente;
        this.venta = venta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", venta=" + venta + '}';
    }

}

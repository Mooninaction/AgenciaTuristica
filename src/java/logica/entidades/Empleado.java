package logica.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import logica.Cargo;
import logica.Venta;

@Entity
public class Empleado extends Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmpleado;
    @OneToOne
    private Cargo cargo;
    private double sueldo;
    @OneToOne
    public Usuario usuario;
    @OneToMany
    public List<Venta> listaVentas;

    public Empleado() {
    }

    public Empleado(int idEmpleado, Cargo cargo, double sueldo, Usuario usuario, List<Venta> listaVentas) {
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVentas = listaVentas;
    }

    public Empleado(int idEmpleado, Cargo cargo, double sueldo, Usuario usuario, List<Venta> listaVentas, String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email) {
        super(nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.listaVentas = listaVentas;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", cargo=" + cargo + ", sueldo=" + sueldo + ", usuario=" + usuario + ", listaVentas=" + listaVentas + '}';
    }

}

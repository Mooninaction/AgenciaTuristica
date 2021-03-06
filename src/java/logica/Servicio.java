package logica;

import logica.enumera.TipoServicio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoServicio;
    @Basic
    private String nombre;
    private String descripcionBreve;
    private String destinoServicio;
    @Temporal(TemporalType.DATE)
    private Date fechaServicio;
    double costoServicio;
    private TipoServicio tipoServicio;
    @ManyToMany
    public List<PaqueteTuristico> listaPaquetes;

    public Servicio() {
    }

    public Servicio(int codigoServicio, String nombre, String descripcionBreve, String destinoServicio, Date fechaServicio, double costoServicio, TipoServicio tipoServicio, List<PaqueteTuristico> listaPaquetes) {
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.descripcionBreve = descripcionBreve;
        this.destinoServicio = destinoServicio;
        this.fechaServicio = fechaServicio;
        this.costoServicio = costoServicio;
        this.tipoServicio = tipoServicio;
        this.listaPaquetes = listaPaquetes;
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDestinoServicio() {
        return destinoServicio;
    }

    public void setDestinoServicio(String destinoServicio) {
        this.destinoServicio = destinoServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public List<PaqueteTuristico> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<PaqueteTuristico> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    void setCostoServicio(Double costo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Servicio{" + "codigoServicio=" + codigoServicio + ", nombre=" + nombre + ", descripcionBreve=" + descripcionBreve + ", destinoServicio=" + destinoServicio + ", fechaServicio=" + fechaServicio + ", costoServicio=" + costoServicio + ", tipoServicio=" + tipoServicio + ", listaPaquetes=" + listaPaquetes + '}';
    }

}

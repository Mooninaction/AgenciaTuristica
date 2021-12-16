package logica;

import java.util.Date;
import java.util.List;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class Servicio {

    private int codigoServicio;
    private String nombre;
    private String descripcionBreve;
    private String destinoServicio;
    private Date fechaServicio;
    private int costoServicio;
    private tipoServicio tipoServicio;
    @ManyToMany
    public List<PaqueteTuristico> listaPaquetes;
    @OneToMany
    public Venta venta;
    
    public Servicio() {
    }

    public Servicio(int codigoServicio, String nombre, String descripcionBreve, String destinoServicio, Date fechaServicio, int costoServicio, tipoServicio tipoServicio, List<PaqueteTuristico> listaPaquetes, Venta venta) {
        this.codigoServicio = codigoServicio;
        this.nombre = nombre;
        this.descripcionBreve = descripcionBreve;
        this.destinoServicio = destinoServicio;
        this.fechaServicio = fechaServicio;
        this.costoServicio = costoServicio;
        this.tipoServicio = tipoServicio;
        this.listaPaquetes = listaPaquetes;
        this.venta = venta;
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

    public int getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(int costoServicio) {
        this.costoServicio = costoServicio;
    }

    public tipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(tipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public List<PaqueteTuristico> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<PaqueteTuristico> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
}
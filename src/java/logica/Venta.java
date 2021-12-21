package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import logica.enumera.MedioPago;
import logica.enumera.TipoContratacion;

@Entity
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numVenta;
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    private MedioPago medioPago;
    private TipoContratacion tipocontratacion;
    @ManyToOne
    private PaqueteTuristico paqueteTuristico;
    @ManyToOne
    private Servicio servicio;

    public Venta() {
    }

    public Venta(int numVenta, Date fechaVenta, MedioPago medioPago,TipoContratacion tipoCotratacion, PaqueteTuristico paqueteTuristico, Servicio servicio) {
        this.numVenta = numVenta;
        this.fechaVenta = fechaVenta;
        this.medioPago = medioPago;
        this.tipocontratacion = tipoCotratacion;
        this.paqueteTuristico = paqueteTuristico;
        this.servicio = servicio;
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

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(MedioPago medioPago) {
        this.medioPago = medioPago;
    }

    public TipoContratacion getTipocontratacion() {
        return tipocontratacion;
    }

    public void setTipocontratacion(TipoContratacion tipocontratacion) {
        this.tipocontratacion = tipocontratacion;
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

    @Override
    public String toString() {
        return "Venta{" + "numVenta=" + numVenta + ", fechaVenta=" + fechaVenta + ", medioPago=" + medioPago + ", tipocontratacion=" + tipocontratacion + ", paqueteTuristico=" + paqueteTuristico + ", servicio=" + servicio + '}';
    }


}

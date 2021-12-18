package logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPago;
    private double comision;

    @Temporal(TemporalType.DATE)
    private Date fechaPago;

    @Temporal(TemporalType.TIME)
    private Date horaPago;
    private double importe;
    private String medioDPago;

    public Pago() {
    }

    public Pago(int idPago, double comision, Date fechaPago, Date horaPago, double importe, String medioDPago) {
        this.idPago = idPago;
        this.comision = comision;
        this.fechaPago = fechaPago;
        this.horaPago = horaPago;
        this.importe = importe;
        this.medioDPago = medioDPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(Date horaPago) {
        this.horaPago = horaPago;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getMedioDPago() {
        return medioDPago;
    }

    public void setMedioDPago(String medioDPago) {
        this.medioDPago = medioDPago;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", comision=" + comision + ", fechaPago=" + fechaPago + ", horaPago=" + horaPago + ", importe=" + importe + ", medioDPago=" + medioDPago + '}';
    }

}

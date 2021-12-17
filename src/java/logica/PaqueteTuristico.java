package logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PaqueteTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigoPaquete;
    private double costoPaquete;
    @ManyToMany
    public List<Servicio> listaServicios;

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(int codigoPaquete, int costoPaquete, List<Servicio> listaServicios) {
        this.codigoPaquete = codigoPaquete;
        this.costoPaquete = costoPaquete;
        this.listaServicios = listaServicios;
    }

    public int getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(int codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public double getCostoPaquete() {
        return costoPaquete;
    }

    public void setCostoPaquete(double costoPaquete) {
        this.costoPaquete = costoPaquete;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

}

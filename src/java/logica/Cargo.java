package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import logica.entidades.Empleado;

@Entity
public class Cargo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCargo;
    private String nombreCargo;
    private String tarea;
    private double sueldoBase;
    @OneToMany
    private List<Empleado> listaEmpleados;
    
    public Cargo(){
        
    }

    public Cargo(int idCargo, String nombreCargo, String tarea, double sueldoBase, List<Empleado> listaEmpleados) {
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        this.tarea = tarea;
        this.sueldoBase = sueldoBase;
        this.listaEmpleados = listaEmpleados;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public String toString() {
        return "Cargo{" + "idCargo=" + idCargo + ", nombreCargo=" + nombreCargo + ", tarea=" + tarea + ", sueldoBase=" + sueldoBase + ", listaEmpleados=" + listaEmpleados + '}';
    }
    
    
    
}

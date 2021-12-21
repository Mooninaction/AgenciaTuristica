package persistencia;

import java.util.List;
import logica.Cargo;
import logica.PaqueteTuristico;
import logica.Servicio;
import logica.Venta;
import logica.entidades.Empleado;
import logica.entidades.Usuario;

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    ServicioJpaController servJPA = new ServicioJpaController();
    PaqueteTuristicoJpaController paqJPA = new PaqueteTuristicoJpaController();
    VentaJpaController ventJPA = new VentaJpaController();
    CargoJpaController cargoJPA = new CargoJpaController();
    
    public List<Usuario> traerUsuarios() {
        return usuJPA.findUsuarioEntities();        
    }
    
    public void crearServicio(Servicio servicio) {
        servJPA.create(servicio);
    }
    
    public void crearPaquete(PaqueteTuristico paquete) {
        paqJPA.create(paquete);
    }
    
    public void crearVenta(Venta venta) {
        ventJPA.create(venta);
    }
    
    public void crearEmpleado(Empleado empleado, Cargo cargo, Usuario usuario) {
        usuJPA.create(usuario);        
        cargoJPA.create(cargo);
        empleJPA.create(empleado);
    }
    
}

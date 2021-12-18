package persistencia;

import java.util.List;
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
    
    public void crearEmpleado(Empleado empleado, Usuario usuario) {
        
        usuJPA.create(usuario); 
        empleJPA.create(empleado);       
    }

    public List<Usuario> traerUsuarios() {
         return usuJPA.findUsuarioEntities(); 
    }

    public void crearServicio(Servicio servicio) {
       servJPA.create(servicio);
    }
    
    public void crearPaquete(PaqueteTuristico paquete) {
        paqJPA.create(paquete);
    }
    
    public void crearVenta(Venta venta){
        ventJPA.create(venta);
    }
    
}

package persistencia;

import java.util.List;
import logica.entidades.Empleado;
import logica.entidades.Usuario;

public class ControladoraPersistencia {

    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    
    public void crearEmpleado(Empleado empleado, Usuario usuario) {
        
        usuJPA.create(usuario); 
        empleJPA.create(empleado);       
    }

    public List<Usuario> traerUsuarios() {
         return usuJPA.findUsuarioEntities(); 
    }
    
}

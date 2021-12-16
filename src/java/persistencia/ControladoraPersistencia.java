package persistencia;

import logica.entidades.Empleado;
import logica.entidades.Usuario;

public class ControladoraPersistencia {

    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    
    public void crearEmpleado(Empleado empleado, Usuario usuario) {
        
        usuJPA.create(usuario); 
        empleJPA.create(empleado);       
    }
    
}

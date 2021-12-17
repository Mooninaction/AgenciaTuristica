package logica;

import java.util.List;
import logica.entidades.Empleado;
import logica.entidades.Usuario;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        if (listaUsuarios != null){
            for (Usuario usu : listaUsuarios){
                if (usu.getNombreUsuario().equals(usuario) 
                        && usu.getContrasenia().equals(contrasenia)){
                    return true;
                }
            }
        }
        return false;
    }

    public void crearEmpleado(String nombre, String apellido, String cargo, double sueldo, String nombreUsuario, String contrasenia) {

        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();

        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);

        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);

        empleado.setUsuario(usuario);

        controlPersis.crearEmpleado(empleado, usuario);

    }

}

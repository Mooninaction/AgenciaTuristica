package logica;

import java.util.Date;
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

    public void crearEmpleado(String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email, String cargo, double sueldo, String nombreUsuario, String contrasenia) {
        Empleado empleado = new Empleado();
        Usuario usuario = new Usuario();

        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setCargo(cargo);
        empleado.setSueldo(sueldo);

        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);

        empleado.setUsuario(usuario);

        controlPersis.crearEmpleado(empleado, usuario);
    }

    public void crearServicio(String nombre, String descripcion, String destino, Date fecha, Double costo) {
        Servicio servicio = new Servicio();
        servicio.setNombre(nombre);
        servicio.setDescripcionBreve(descripcion);
        servicio.setDestinoServicio(destino);
        servicio.setFechaServicio(fecha);
        servicio.setCostoServicio(costo);
        
        controlPersis.crearServicio(servicio);
    }
    // crear Venta y Paquete de igual forma q serv y empleado, desp terminar con login, después ver el error con la base de datos y con el bttn enviar

}

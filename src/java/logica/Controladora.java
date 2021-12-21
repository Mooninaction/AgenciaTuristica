package logica;

import java.util.Date;
import java.util.List;
import logica.entidades.Empleado;
import logica.entidades.Usuario;
import logica.Cargo;
import logica.enumera.MedioPago;
import logica.enumera.TipoContratacion;
import logica.enumera.TipoServicio;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    Empleado empleado = new Empleado();
    Usuario usuario = new Usuario();
    Cargo cargo = new Cargo();
    Servicio servicio = new Servicio();
    Venta venta = new Venta();

    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        if (listaUsuarios != null) {
            for (Usuario usu : listaUsuarios) {
                if (usu.getNombreUsuario().equals(usuario)
                        && usu.getContrasenia().equals(contrasenia)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void crearEmpleado(String nombre, String apellido, String direccion, String dni, Date fechaNacimiento, String nacionalidad, String celular, String email, String nombreCargo, String tarea, double sueldo, String nombreUsuario, String contrasenia) {

        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDireccion(direccion);
        empleado.setDni(dni);
        empleado.setFechaNacimiento(fechaNacimiento);
        empleado.setNacionalidad(nacionalidad);
        empleado.setCelular(celular);
        empleado.setEmail(email);
        empleado.setSueldo(sueldo);

        cargo.setNombreCargo(nombreCargo);
        cargo.setTarea(tarea);

        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContrasenia(contrasenia);

        empleado.setUsuario(usuario);

        controlPersis.crearEmpleado(empleado, cargo, usuario);
    }

    public void crearServicio(String nombre, String descripcionBreve, String destinoServicio, Date fechaServicio, Double costoServicio, String tipoServicio) {

        servicio.setNombre(nombre);
        servicio.setDescripcionBreve(descripcionBreve);
        servicio.setDestinoServicio(destinoServicio);
        servicio.setFechaServicio(fechaServicio);
        servicio.setCostoServicio(costoServicio);
        servicio.setTipoServicio(TipoServicio.valueOf(tipoServicio));

        controlPersis.crearServicio(servicio);
    }

    // crear Venta y Paquete de igual forma q serv y empleado, desp terminar con login, después ver el error con la base de datos y con el bttn enviar

    public void crearVenta(Date fechaVenta, String medioPago, String tipoContratacion, String paquete, String servicio) {
        
        venta.setFechaVenta(fechaVenta);
        venta.setMedioPago(MedioPago.valueOf(medioPago));
        venta.setTipocontratacion(TipoContratacion.valueOf(tipoContratacion));
        
        
//        venta.setServicio(servicio);
//        venta.setPaqueteTuristico(paquete);
        controlPersis.crearVenta(venta);
    }
}

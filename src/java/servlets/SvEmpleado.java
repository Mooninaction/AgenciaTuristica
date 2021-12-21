package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    Controladora control = new Controladora();
    SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            //traigo los atributos del front
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String dni = request.getParameter("dni");
            
            Date fechaNacimiento = simpleFormat.parse(request.getParameter("fechaNacimiento"));
            String nacionalidad = request.getParameter("nacionalidad");
            String celular = request.getParameter("celular");
            String email = request.getParameter("email");

            String cargo = request.getParameter("cargo");
            String tarea = request.getParameter("tarea");
            double sueldo = Double.parseDouble(request.getParameter("sueldo"));

            String nombreUsuario = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contrasenia");

            Boolean activo = Boolean.parseBoolean(request.getParameter("activo"));

            //traigo la sesión actual y le pasamos los atributos recibidos
            request.getSession().setAttribute("nombre", nombre);
            request.getSession().setAttribute("apellido", apellido);
            request.getSession().setAttribute("direccion", direccion);
            request.getSession().setAttribute("dni", dni);
            request.getSession().setAttribute("fechaNacimiento", fechaNacimiento);
            request.getSession().setAttribute("nacionalidad", nacionalidad);
            request.getSession().setAttribute("celular", celular);
            request.getSession().setAttribute("email", email);

            request.getSession().setAttribute("cargo", cargo);
            request.getSession().setAttribute("tarea", tarea);
            request.getSession().setAttribute("sueldo", sueldo);
            
            request.getSession().setAttribute("nombreUsuario", nombreUsuario);
            request.getSession().setAttribute("contrasenia", contrasenia);
            
            request.getSession().setAttribute("activo", activo);
            
            
            //creo una instancia de la controladora para enviar a la logica los datos
            control.crearEmpleado(nombre, apellido, direccion, dni, fechaNacimiento, nacionalidad, celular, email, cargo, tarea, sueldo, nombreUsuario, contrasenia);
            
            //enviamos la respuesta a la solicitud realizada
            response.sendRedirect("index.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

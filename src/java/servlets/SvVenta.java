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

@WebServlet(name = "SvVenta", urlPatterns = {"/SvVenta"})
public class SvVenta extends HttpServlet {
    
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
            Date fechaVenta = simpleFormat.parse(request.getParameter("fechaVenta"));
            String medioPago = request.getParameter("medioPago");
            String tipoContratacion = request.getParameter("tipoContratacion");
            String paquete = request.getParameter("paquete");
            String servicio = request.getParameter("servicio");
            
            Boolean activo = Boolean.parseBoolean(request.getParameter("activo"));
            
            //traigo la sesión actual y le pasamos los atributos recibidos
            request.getSession().setAttribute("fechaVenta", fechaVenta);
            request.getSession().setAttribute("medioPago", medioPago);
            request.getSession().setAttribute("tipoContratacion", tipoContratacion);
            request.getSession().setAttribute("paquete", paquete);
            request.getSession().setAttribute("servicio", servicio);
            
            request.getSession().setAttribute("activo", activo);
            
            control.crearVenta(fechaVenta, medioPago, tipoContratacion, paquete, servicio);
            
            response.sendRedirect("index.jsp");
            
        } catch (ParseException ex) {
            Logger.getLogger(SvVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

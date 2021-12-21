package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;

@WebServlet(name = "SvServicio", urlPatterns = {"/SvServicio"})
public class SvServicio extends HttpServlet {
    
    Controladora control = new Controladora();
    SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");

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
            String nombre = request.getParameter("nombre");
            String descripcionBreve = request.getParameter("descripcionBreve");
            String destinoServicio = request.getParameter("destinoServicio");
            Date fechaServicio = simpleFormat.parse(request.getParameter("fechaServicio"));
            Double costoServicio = Double.parseDouble(request.getParameter("costoServicio"));
            String tipoServicio = request.getParameter("tipoServicio");

            Boolean activo = Boolean.parseBoolean(request.getParameter("activo"));
            
            request.getSession().setAttribute("nombre", nombre);
            request.getSession().setAttribute("descripcionBreve", descripcionBreve);
            request.getSession().setAttribute("destinoServicio", destinoServicio);
            request.getSession().setAttribute("fechaServicio", fechaServicio);
            request.getSession().setAttribute("costoServicio", costoServicio);
            request.getSession().setAttribute("tipoServicio", tipoServicio);
            request.getSession().setAttribute("activo", activo);
            
            response.sendRedirect("index.jsp");
            
            control.crearServicio(nombre, descripcionBreve, destinoServicio, fechaServicio, costoServicio, tipoServicio);
            
        } catch (ParseException ex) {
            Logger.getLogger(SvEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

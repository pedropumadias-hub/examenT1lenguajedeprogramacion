package control;

import dao.ProyectoDAO;
import modelo.Proyecto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProyectoServlet")
public class ProyectoServlet extends HttpServlet {
    private ProyectoDAO dao = new ProyectoDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion == null || accion.equals("listar")) {
            List<Proyecto> lista = dao.listarProyectos();
            request.setAttribute("proyectos", lista);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String inicio = request.getParameter("fechaInicio"); 
        String fin = request.getParameter("fechaFin");         
        String asesor = request.getParameter("asesor");
        String presustr = request.getParameter("presupuesto");

        if (nombre == null || nombre.trim().length() < 4 || 
            inicio == null || inicio.isEmpty() || 
            fin == null || fin.isEmpty() || 
            asesor == null || asesor.isEmpty() || 
            presustr == null || presustr.isEmpty()) {
            
            request.setAttribute("error", "Error: Todos los campos son obligatorios y el nombre debe tener al menos 4 caracteres.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        double presupuesto = Double.parseDouble(presustr);
        
        Proyecto p = new Proyecto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setFechaInicio(inicio);
        p.setFechaFin(fin);
        p.setAsesorTecnico(asesor);
        p.setPresupuesto(presupuesto);
        
        dao.registrarProyecto(p);

        response.sendRedirect("ProyectoServlet?accion=listar");
    }
}
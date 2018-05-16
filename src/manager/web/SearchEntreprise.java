package manager.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Empresa;
import manager.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/search")
public class SearchEntreprise extends HttpServlet {
	
	private static final long serialVersionUID = -5640846148829616329L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    PrintWriter writer = resp.getWriter();
	    writer.println("<html>");
	    writer.println("<body>");
	    writer.println("<h1>Search results:</h1><br/>");

	    String filtro = req.getParameter("filter");
	    Collection<Empresa> empresas = new EmpresaDAO()
	            .buscaPorSimilaridade(filtro);

	    writer.println("<ul>");
	    for (Empresa empresa : empresas) {
	        writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
	    }
	    writer.println("</ul>");

	    writer.println("</body>");
	    writer.println("</html>");


	}
}
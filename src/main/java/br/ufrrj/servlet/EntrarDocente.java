package br.ufrrj.servlet;

import java.io.IOException;

import br.ufrrj.DAO.DocenteDAO;
import br.ufrrj.model.Docente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EntrarDocente
 */
@WebServlet("/entrarDocente.do")
public class EntrarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrarDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("username");
		String senha = request.getParameter("password");
		
		DocenteDAO docenteDAO = new DocenteDAO();
		Docente d;
		try {
			d = docenteDAO.buscarUsuario(usuario, senha);
			if(d != null) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1800);
				session.setAttribute("docente", d);
				response.sendRedirect("http://localhost:8080/Sistemas/paginaProfessor.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("erro "+e.getMessage());
		}
		

	}

}

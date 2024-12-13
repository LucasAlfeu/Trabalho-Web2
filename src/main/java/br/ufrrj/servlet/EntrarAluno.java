package br.ufrrj.servlet;

import java.io.IOException;

import br.ufrrj.DAO.DiscenteDAO;
import br.ufrrj.model.Discente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EntrarAluno
 */
@WebServlet("/entrarAluno.do")
public class EntrarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrarAluno() {
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
		
		DiscenteDAO discenteDAO = new DiscenteDAO();
		Discente d = null;
		try {
			d = discenteDAO.buscarUsuario(usuario, senha);
			if(d != null) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(1800);
				session.setAttribute("discente", d);
				response.sendRedirect("http://localhost:8080/Sistemas/paginaAluno.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("erro: "+e.getMessage());
		}
		

	}

}

package br.ufrrj.servlet;

import java.io.IOException;

import br.ufrrj.DAO.DocenteDAO;
import br.ufrrj.model.Docente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarDocente
 */
@WebServlet("/cadastrarDocente.do")
public class CadastrarDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastrarDocente() {
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
		String nome = request.getParameter("name");
		String usuario = request.getParameter("username");
		String senha = request.getParameter("password");
		String identificacao = request.getParameter("registration");
		String email = request.getParameter("email");
		
		Docente d = new Docente(usuario, senha, nome, identificacao);
		DocenteDAO docenteDAO = new DocenteDAO();
		try {
			docenteDAO.cadastrarDocente(d);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:8080/Sistemas/entrarProfessor.jsp");
	}

}

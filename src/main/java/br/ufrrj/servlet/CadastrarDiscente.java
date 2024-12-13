package br.ufrrj.servlet;


import java.io.IOException;

import br.ufrrj.DAO.DiscenteDAO;
import br.ufrrj.model.Discente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarDiscente
 */
@WebServlet("/cadastrarDiscente.do")
public class CadastrarDiscente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarDiscente() {
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
		String nome = request.getParameter("nome");
		String usuario = request.getParameter("username");
		String senha = request.getParameter("password");
		String matricula = request.getParameter("registration");
		String email = request.getParameter("email");
		
		Discente d = new Discente(nome, usuario, senha, matricula, email);
		
		DiscenteDAO discenteDAO = new DiscenteDAO();
		try {
			discenteDAO.cadastrarDiscente(d);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erro "+e.getMessage());
		}
		
		response.sendRedirect("http://localhost:8080/Sistemas/entrarAluno.jsp");
	}

}


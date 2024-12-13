package br.ufrrj.servlet;

import java.io.IOException;

import br.ufrrj.DAO.ResultadoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SobreMatricula
 */
@WebServlet("/SobreMatricula")
public class SobreMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SobreMatricula() {
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
		int idDisciplina = Integer.parseInt(request.getParameter("idDisciplina"));
		int idAluno = Integer.parseInt(request.getParameter("idAluno"));
		
		ResultadoDAO resDAO = new ResultadoDAO();
		try {
			resDAO.cadastraResultado(idAluno, idDisciplina);
			System.out.println("Aluno matriculado com sucesso");
			response.sendRedirect("http://localhost:8080/Sistemas/paginaAluno.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro: "+e.getMessage());
		}
	}

}

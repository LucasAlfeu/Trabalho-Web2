package br.ufrrj.servlet;

import java.io.IOException;
import java.util.List;

import br.ufrrj.DAO.ResultadoDAO;
import br.ufrrj.model.Resultado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sobreTurma
 */
@WebServlet("/sobreTurma")
public class sobreTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sobreTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
      	ResultadoDAO resDAO = new ResultadoDAO();
      	List<Resultado> minhaLista = null;
      	try {
			minhaLista = resDAO.buscarTodosResultadoPorIdDicplinsa(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("lista", minhaLista);
		request.getRequestDispatcher("sobreTurma.jsp").forward(request, response);
		response.sendRedirect("http://localhost:8080/Sistemas/sobreTurma.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

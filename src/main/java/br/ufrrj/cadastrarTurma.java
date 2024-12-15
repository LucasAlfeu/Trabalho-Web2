package br.ufrrj;

import java.io.IOException;
import java.util.List;

import br.ufrrj.DAO.DisciplinaDAO;
import br.ufrrj.DAO.DocenteDAO;
import br.ufrrj.model.Disciplina;
import br.ufrrj.model.Docente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cadastrarTurma
 */
@WebServlet("/cadastrarTurma.do")
public class cadastrarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DocenteDAO docenteDAO = new DocenteDAO();
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        
        String nomeDisciplina = request.getParameter("nome");
        String cargaHorariaStr = request.getParameter("cargaHoraria");
        String numAlunosStr = request.getParameter("numAlunos");
        String periodoStr = request.getParameter("periodo");
        String nomeDocente = request.getParameter("docente");

        // Validate inputs
        if (nomeDisciplina == null || nomeDisciplina.trim().isEmpty() ||
                cargaHorariaStr == null || cargaHorariaStr.trim().isEmpty() ||
                numAlunosStr == null || numAlunosStr.trim().isEmpty() ||
                periodoStr == null || periodoStr.trim().isEmpty() ||
                nomeDocente == null || nomeDocente.trim().isEmpty()) {

            throw new IllegalArgumentException("Todos os campos são obrigatórios");
        }

        int cargaHoraria = Integer.parseInt(cargaHorariaStr);
        int numAlunos = Integer.parseInt(numAlunosStr);
        String periodo = periodoStr;

        Docente docente = null;
		try {
			docente = docenteDAO.buscarDocentePorNome(nomeDocente);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Disciplina disciplina = new Disciplina();
        disciplina.setNomeDisciplina(nomeDisciplina);
        disciplina.setCargaHoraria(cargaHoraria);
        disciplina.setMaxAlunos(numAlunos);
        disciplina.setPeriodo(periodo);
        disciplina.setIdDocente(docente.getIdDocente());

        try {
			disciplinaDAO.cadastrarDiscilpina(disciplina, docente.getIdDocente());
	        request.getRequestDispatcher("/paginaProfessor.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

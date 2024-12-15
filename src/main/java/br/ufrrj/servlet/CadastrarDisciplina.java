package br.ufrrj.servlet;

import br.ufrrj.DAO.*;
import br.ufrrj.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/CadastrarDisciplina")
public class CadastrarDisciplina extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DocenteDAO docenteDAO;
    private DisciplinaDAO disciplinaDAO;

    public void init() {
        docenteDAO = new DocenteDAO();
        disciplinaDAO = new DisciplinaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Listar docentes
            List<Docente> listaDocentes = docenteDAO.listarDocentes();
            request.setAttribute("listaDocentes", listaDocentes);

            request.getRequestDispatcher("/cadastrarDisciplina.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("erro", "Erro ao carregar lista de docentes: " + e.getMessage());
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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

            Docente docente = docenteDAO.buscarDocentePorNome(nomeDocente);
            if (docente == null) {
                throw new IllegalArgumentException("Docente não encontrado");
            }

            Disciplina disciplina = new Disciplina();
            disciplina.setNomeDisciplina(nomeDisciplina);
            disciplina.setCargaHoraria(cargaHoraria);
            disciplina.setMaxAlunos(numAlunos);
            disciplina.setPeriodo(periodo);
            disciplina.setIdDocente(docente.getIdDocente());

            disciplinaDAO.cadastrarDiscilpina(disciplina, docente.getIdDocente());

            request.setAttribute("mensagem", "Disciplina cadastrada com sucesso!");

            request.getRequestDispatcher("/paginaProfessor.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("erro", "Formato inválido de número. Verifique os valores inseridos.");

            try {
                List<Docente> listaDocentes = docenteDAO.listarDocentes();
                request.setAttribute("listaDocentes", listaDocentes);
            } catch (Exception ex) {
            }

            request.getRequestDispatcher("/cadastrarDisciplina.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            request.setAttribute("erro", e.getMessage());

            try {
                List<Docente> listaDocentes = docenteDAO.listarDocentes();
                request.setAttribute("listaDocentes", listaDocentes);
            } catch (Exception ex) {
            }

            request.getRequestDispatcher("/cadastrarDisciplina.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("erro", "Erro ao cadastrar disciplina: " + e.getMessage());
        }
    }
}
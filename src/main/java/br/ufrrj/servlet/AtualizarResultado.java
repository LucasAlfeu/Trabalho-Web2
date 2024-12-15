package br.ufrrj.servlet;


import java.io.IOException;

import br.ufrrj.DAO.*;
import br.ufrrj.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastrarDiscente
 */
@WebServlet("/atualizarResultado.do")
public class AtualizarResultado extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarResultado() {
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
        int idDiscente = Integer.parseInt(request.getParameter("idDiscente"));
        float nota = Float.parseFloat(request.getParameter("nota"));
        String status = "";
        
        if(nota>=5) {
        	status = "APROVADO";
        } else {
        	status = "REPROVADO";
        }

        Resultado resultado = new Resultado();

        resultado.setIdDisciplina(idDisciplina);
        resultado.setIdDiscente(idDiscente);
        resultado.setNota(nota);
        resultado.setStatus(status);

        ResultadoDAO resultadoDAO = new ResultadoDAO();
        try {
            resultadoDAO.atualizarNota(resultado.getIdDisciplina(), resultado.getIdDiscente(), resultado.getStatus(), resultado.getNota());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro "+e.getMessage());
        }

        response.sendRedirect("http://localhost:8080/Sistemas/sobreTurma?id="+idDisciplina);
    }

}

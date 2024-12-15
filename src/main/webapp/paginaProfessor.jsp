<!DOCTYPE html>
<%@ page import="br.ufrrj.model.*" %>
<%@ page import="br.ufrrj.DAO.*" %>
<%@ page import="java.util.List" %>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/paginaProfessor.css">
  <title>PÃ¡gina do Professor</title>
</head>
<body>
<header>

      <%Docente docente = (Docente) session.getAttribute("docente");%>

	<%if (docente == null) { response.sendRedirect("index.jsp"); } %>
    <h1>Página do Professor</h1>
    <nav>
      <a href="./paginaProfessor.jsp">Início</a>
      <a href="./index.jsp">Sair</a>
    </nav>
</header>

<div class="container">
    <div class="box">
        <h2><%= docente.getNome() %></h2>
        <div class="actions">
            	<a href="./novaDisciplina.jsp">Cadastrar</a>
            	<a href="./paginaPromocao.jsp">Promoção</a>
        </div>
    </div>
    <table>
      <thead>
        <tr>
          <th>Nome da Disciplina</th>
          <th>Cadastrar Notas</th>
        </tr>
      </thead>
      <tbody>
      <%
      	ResultadoDAO resDAO = new ResultadoDAO();
      	DisciplinaDAO disDAO = new DisciplinaDAO();
      	List<Resultado> minhaLista = resDAO.buscarTodosResultadoPorIdDiscente(docente.getIdDocente());
      	if(minhaLista != null){
      		for(Resultado r : minhaLista){
      			Disciplina dis = disDAO.buscaDisciplinaPorId(r.getIdDisciplina());
      	%>
        <tr>
          <td><%= dis.getNomeDisciplina() %></td>
          <td class="actions">
            <a href="sobreTurma?id=<%= dis.getIdDisciplina() %>">Saiba Mais</a>
          </td>
        </tr>
        <% 
      		}
      	}
        %>
      </tbody>
    </table>
  </div>
</body>
</html>
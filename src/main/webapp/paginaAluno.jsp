<%@ page import="br.ufrrj.DAO.*" %>
<%@ page import="br.ufrrj.model.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<%@ page import="br.ufrrj.model.Discente" %>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/paginaAluno.css">
  <title>Página do Aluno</title>
</head>
<body>
  <header>
  
      <%Discente discente = (Discente) session.getAttribute("discente");%>

	<%if (discente == null) { response.sendRedirect("index.jsp"); } %>
    <h1>Página do Aluno</h1>
    <nav>
      <a href="./paginaAluno.jsp">Início</a>
      <a href="./matricular.jsp">Matricular-se</a>
      <a href="./index.jsp">Sair</a>
    </nav>
  </header>

  <div class="container">
    <h2><%= discente.getNome() %></h2>
    <table>
      <thead>
        <tr>
          <th>Turma</th>
          <th>Carga Horária</th>
          <th>Nota</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
      <%
      	ResultadoDAO resDAO = new ResultadoDAO();
      	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
      	List<Resultado> minhaLista = resDAO.buscarTodosResultadoPorIdDiscente(discente.getIdDiscente());
      	if(minhaLista != null){
      		for(Resultado r : minhaLista){
      			Disciplina d = disciplinaDAO.buscaDisciplinaPorId(r.getIdDisciplina());
      %>
        <tr>
          <td><%= d.getNomeDisciplina() %></td>
          <td><%= d.getCargaHoraria() %>h</td>
          <td><%= r.getNota() %></td>
          <td class="status"><%= r.getStatus() %></td>
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
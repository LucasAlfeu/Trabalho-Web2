<%@ page import="br.ufrrj.DAO.*" %>
<%@ page import="br.ufrrj.model.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/matricular.css">
  <title>Matricular</title>
  
  <% 
  		Discente aluno = (Discente) session.getAttribute("discente");
  %>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>Matricular</h1>
    </div>
    <table class="formulario">
        <thead>
            <tr>
                <th>Disciplina</th>
                <th>Vagas Discponíveis</th>
                <th>Carga Horária</th>
                <th>Cadastrar</th>
            </tr>
        </thead>
        <tbody>
        <%
	      	DisciplinaDAO disciplinaDAO = new DisciplinaDAO(); 
	      	List<Disciplina> minhaLista = disciplinaDAO.buscarTodasDisciplinas();
        	if(minhaLista != null){
        		for(Disciplina disciplina : minhaLista){ 
        			int vagas = disciplina.getMaxAlunos() - disciplina.getNumDiscentesMatriculados();
        		%>
        		<tr>
	                <td><%= disciplina.getNomeDisciplina() %></td>
	                <td><%= vagas %></td>
	                <td><%= disciplina.getCargaHoraria() %> h</td>
	                <td>
	                	<form action="SobreMatricula" method="POST">
	                		<input type="hidden" name="idDisciplina" value="<%= disciplina.getIdDisciplina() %>">
	                		<input type="hidden" name="idAluno" value="<%= aluno.getIdDiscente() %>">
	                		<input type="submit" value="Cadastrar">
	                	</form>
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
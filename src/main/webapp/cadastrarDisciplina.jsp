<%@ page import="br.ufrrj.DAO.DocenteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufrrj.model.Docente" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/turma.css">
  <title>Cadastrar Disciplina</title>
</head>
<body>
	<% DocenteDAO docenteDAO = new DocenteDAO(); %>
  <div class="container">
    <div class="header">
      <h1>Cadastrar Disciplina</h1>
    </div>
    <form class="formulario">
      <div class="form-group">
        <label for="name">Nome Disciplina:</label>
        <input type="text" id="name" name="nome" placeholder="Digite o nome da disciplina">
      </div>
      <div class="form-group">
        <label for="instructor">Carga Horária:</label>
        <input type="text" id="instructor" name="cargaHoraria" placeholder="Digite a carga horária da disciplina">
      </div>
      <div class="form-group">
        <label for="students">Número de Alunos:</label>
        <input type="text" id="students" name="numAlunos" placeholder="Digite o número de alunos na disciplina">
      </div>
      <div class="form-group">
        <label for="periodo">Período:</label>
        <input type="number" id="periodo" name="periodo" placeholder="Digite o período da disciplina">
      </div>
       <div class="form-group">
       <p>Escolha o docente</p>
        <div>
			<label for="docente">Docente:</label>
        	<select id="docente" name="docente">
       		<%
       			List<Docente> lista = null;
        		if(lista != null){
        			for(Docente d : lista){
        	%>
        		<option><%= d.getNome() %></option>
			<%
        			}
        		} else {
			%>
				<option>Nenhum docente cadastrado</option>
			<% } %>
        	</select>
        	
        </div>
      </div>
      <div class="buttons">
        <button type="button">Cancelar</button>
        <button type="submit">Cadastrar</button>
      </div>
    </form>
  </div>
</body>
</html>
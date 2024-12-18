<%@ page import="br.ufrrj.DAO.*" %>
<%@ page import="br.ufrrj.model.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>P�gina de Notas</title>
  <link rel="stylesheet" href="./styles/sobreTurma.css">
</head>
<body>
  <header>
    <div class="nav">
      <a href="#">Início</a>
      <a href="#">Sair</a>
    </div>
  </header>

  <main>
    <h1>Nome da Turma</h1>
    <section class="container">
      <section class="form">
      <%
      	List<Resultado> minhaLista = (List<Resultado>) request.getAttribute("lista");
      	DiscenteDAO discenteDAO = new DiscenteDAO();

      	if(minhaLista != null){
      		for(Resultado r : minhaLista){
      			Discente d = discenteDAO.buscarUDiscentePorId(r.getIdDiscente());
      %>
          <form action="atualizarResultado.do" class="renderizar " method="POST">
            <p><%= d.getNome() %></p>
            <div>
              <label for="">Nota: </label>
              <input type="text" name="nota">
              <input type="hidden" name="idDisciplina" value="<%= r.getIdDisciplina() %>">
              <input type="hidden" name="idDiscente" value="<%= r.getIdDiscente() %>">
              <button type="submit">Cadastrar Nota</button>
            </div>
          </form>
        <%	
        }
      	} 
      	%>
        <div class="buttons">
          <button type="reset" onclick="irParaP�gina()">Retornar</button>
        </div>
      </section>
    </section>
  </main>
    <script>
        function irParaPagina() {
            window.location.href = 'paginaProfessor.jsp';
        }
    </script>
</body>
</body>
</html>

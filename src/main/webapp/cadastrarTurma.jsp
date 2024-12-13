<%@ page import="br.ufrrj.DAO.DocenteDAO" %>
<%@ page import="br.ufrrj.model.Docente" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/turma.css">
    <title>Cadastrar Disciplina</title>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Cadastrar Disciplina</h1>
    </div>
    <form class="formulario" action="CadastrarDisciplinaServlet" method="post">
        <div class="form-group">
            <label for="name">Nome Disciplina:</label>
            <input type="text" id="name" name="nome" placeholder="Digite o nome da disciplina" required>
        </div>
        <div class="form-group">
            <label for="instructor">Carga Hor�ria:</label>
            <input type="number" id="instructor" name="cargaHoraria" placeholder="Digite a carga hor�ria da disciplina" required>
        </div>
        <div class="form-group">
            <label for="students">N�mero de Alunos:</label>
            <input type="number" id="students" name="numAlunos" placeholder="Digite o n�mero de alunos na disciplina" required>
        </div>
        <div class="form-group">
            <label for="periodo">Per�odo:</label>
            <input type="number" id="periodo" name="periodo" placeholder="Digite o per�odo da disciplina" required>
        </div>
        <div class="form-group">
            <label for="docente">Docente:</label>
            <input type="text" id="docente" name="docente" placeholder="Digite o nome do Docente" required>
        </div>
        <div class="buttons">
            <button type="button" onclick="window.location.href='index.jsp'">Cancelar</button>
            <button type="submit">Cadastrar</button>
        </div>
    </form>
</div>
</body>
</html>
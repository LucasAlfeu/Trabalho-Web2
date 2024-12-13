<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/turma.css">
  <title>Solicitar Disciplina</title>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>Solicitar Disciplina</h1>
    </div>
    <form class="formulario">
      <div class="form-group">
        <label for="name">Nome Disciplina:</label>
        <input type="text" id="name" name="name" placeholder="Digite o nome da disciplina">
      </div>
      <div class="form-group">
        <label for="instructor">Carga Horária:</label>
        <input type="text" id="instructor" name="instructor" placeholder="Digite a carga horária da disciplina">
      </div>
      <div class="form-group">
        <label for="students">Número de Alunos:</label>
        <input type="text" id="students" name="students" placeholder="Digite o número de alunos na disciplina">
      </div>
      <div class="buttons">
        <button type="button">Cancelar</button>
        <button type="submit">Cadastrar</button>
      </div>
    </form>
  </div>
</body>
</html>
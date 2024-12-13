<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/cadastrar.css">
  <title>Cadastrar Aluno</title>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>Cadastrar Aluno</h1>
    </div>
    <form action="cadastrarDiscente.do" class="formulario" method="POST">
      <div class="form-group">
        <label for="name">Nome:</label>
        <input type="text" id="name" name="nome" placeholder="Digite o nome do aluno">
      </div>
      <div class="form-group">
        <label for="username">Usuário:</label>
        <input type="text" id="username" name="username" placeholder="Digite o usuário do aluno">
      </div>
      <div class="form-group">
        <label for="password">Senha:</label>
        <input type="password" id="password" name="password" placeholder="Digite a senha do aluno">
      </div>
      <div class="form-group">
        <label for="registration">Matrícula:</label>
        <input type="text" id="registration" name="registration" placeholder="Digite a matrícula do aluno">
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Digite o email do aluno">
      </div>
      <div class="buttons">
        <button type="button">Cancelar</button>
        <button type="submit">Cadastrar</button>
      </div>
    </form>
  </div>
</body>
</html>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/cadastrar.css">
  <title>Cadastrar Professor</title>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>Cadastrar Professor</h1>
    </div>
    <form action="cadastrarDocente.do" class="formulario" method="POST">
      <div class="form-group">
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" placeholder="Digite o nome do docente">
      </div>
      <div class="form-group">
        <label for="username">Usuário:</label>
        <input type="text" id="username" name="username" placeholder="Digite o usuário do docente">
      </div>
      <div class="form-group">
        <label for="password">Senha:</label>
        <input type="password" id="password" name="password" placeholder="Digite a senha do docente">
      </div>
      <div class="form-group">
        <label for="registration">Identificação:</label>
        <input type="text" id="registration" name="registration" placeholder="Digite a identificação do Docente">
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" placeholder="Digite o email do docente">
      </div>
      <div class="buttons">
        <button type="button">Cancelar</button>
        <button type="submit">Cadastrar</button>
      </div>
    </form>
  </div>
</body>
</html>
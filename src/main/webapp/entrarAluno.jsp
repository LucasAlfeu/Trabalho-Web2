<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./styles/entrar.css">
  <title>Login</title>

</head>
<body>
  <div class="container">
    <div class="header">
      <h1>Entrar</h1>
    </div>
    <form action="entrarAluno.do" method="POST">
      <div class="form-group">
        <label for="username">Usuário:</label>
        <input type="text" id="username" name="username" placeholder="Digite seu usuário">
      </div>
      <div class="form-group">
        <label for="password">Senha:</label>
        <input type="password" id="password" name="password" placeholder="Digite sua senha">
      </div>
      <div class="buttons">
        <button type="button" onclick="irParaPagina()">Cadastrar</button>
        <button type="submit">Entrar</button>
      </div>
    </form>
  </div>  
  	<script>
        function irParaPagina() {
            window.location.href = 'cadastrarAluno.jsp';
        }
    </script>
</body>
</html>
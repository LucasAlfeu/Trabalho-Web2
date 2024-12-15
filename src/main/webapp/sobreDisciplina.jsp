<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Página de Notas</title>
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
          <form class="renderizar">
            <p>Aluno</p>
            <div>
              <label for="">Nota: </label>
              <input type="text" name="nota">
              <button type="submit">Cadastrar Nota</button>
            </div>
          </form>
        <div class="buttons">
          <button type="reset" onclick="irParaPágina()">Retornar</button>
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

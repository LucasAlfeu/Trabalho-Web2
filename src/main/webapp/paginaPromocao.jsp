<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Promo��oo</title>
    <link rel="stylesheet" href="./styles/promocao.css">
</head>
<body>

    <div class="promotion-form">
        <h1>Promo��o</h1>
        <div class="form-group">
          <label for="identification">Identifica��o:</label>
          <input type="text" id="identification" class="form-control" placeholder="Digite a identifica��o">
        </div>
        <div class="form-actions">
	        <form action="" method="">
	        	<input type="submit" class="btn btn-primary" value="Coordenador">
	        </form>
			<form action="" method="">
	          <input type="submit" class="btn btn-primary" value="Chefe de Departamento">
	        </form>  
	          <button type="submit" class="btn btn-primary" onclick="irParaPagina()">Cancelar</button>
        </div>
      </div>
</body>

  	<script>
        function irParaPagina() {
            window.location.href = 'paginaProfessor.jsp';
        }
    </script>
</html>
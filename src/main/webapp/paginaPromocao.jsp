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
        	<form action="Coordenador" method="POST">
        		<label for="identification">Identifica��o:</label>
	        	<input type="text" name="coordenador" placeholder="Digite a identifica��o">
	        	<input type="submit" class="btn btn-primary" value="Coordenador">
	        </form>
	        </br>
	        </br>
			<form action="Chefe" method="POST">
				<label for="identification">Identifica��o:</label>
				<input type="text" name="chefe" placeholder="Digite a identifica��o">
	          <input type="submit" class="btn btn-primary" value="Chefe de Departamento" >
	        </form>  
	        </br>
        <div class="form-actions">

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
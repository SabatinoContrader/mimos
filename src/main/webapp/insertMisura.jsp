<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuova Misura</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="col-md-8 col-md-offset-4">
	<div class="container center-block col-sm-6">
		<h1>Nuova Misurazione</h1>
		<form action="/paziente/misura" method="post">
		<p>
			Pressione: <input  type=number step=0.01 min="0" id="pressione" name="pressione" class="form-control form-control-lg" required>
		</p>
		<p>
			Battiti: <input  type=number id="battiti" min="0" name="battiti" class="form-control form-control-lg" required>
		</p>
		<p>
			Temperatura:<input  type=number step=0.01 min="0" name="temperatura" class="form-control form-control-lg" required>
		</p>
		<p>
			Glicemia:<input  type=number step=0.01 min="0" name="glicemia"  class="form-control form-control-lg" required>
		</p>
		<button type="submit" class="btn btn-lg btn-primary btn-block submit-button">Aggiungi</button>
		</form>
		<a class="btn btn-lg btn-warning btn-block submit-button " href="/paziente/home">Indietro</a>
	</div>
</div>
</body>
</html>

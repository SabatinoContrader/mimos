<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <title>MI.MO.S</title>
  </head>
  <body>
	<form class="form-signin" action="/login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Entra nella piattaforma</h1>
		<label for="inputUsername" class="sr-only">Username</label>
		<input
			id="inputUsername" class="form-control" placeholder="Username"
			required="required" autofocus="autofocus" type="text">
		<label for="inputPassword" class="sr-only">Password</label>
		<input
			id="inputPassword" class="form-control" placeholder="Password"
			required="required" type="password">
		<div class="checkbox mb-3">
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Sign-in</button>
	</form>
	<br>
	<form class="form-signin" action="/register" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Sei nuovo?</h1>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Register</button>
		<p class="mt-5 mb-3 text-muted">© 2017-2018</p>
	</form>
  </body>
</html>
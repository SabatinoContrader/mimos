<html>
<head>
<title>Login MiMoS</title>
</head>
<body>
   <div>
     <form action = "IndexServlet" method= "post" name="loginform">
     <h3>username: <input type = "text" id = "user" name ="username" placeholder = "inserisci username"></h3>
     <h3>password: <input type = "text" id = "pass" name ="password" placeholder = "inserisci password"></h3>
     <button type = "submit" value = "Login" name = "pulsante">Login In</button><br>
     </form>
   </div>
   <br>
   <div>
     <form action = "IndexServlet" method= "post" name="goregisterform">
     <button type = "submit" value = "goRegister" name = "pulsante">Registrati</button><br>
     </form>
   </div>
</body>
</html>
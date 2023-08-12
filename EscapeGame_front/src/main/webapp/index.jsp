
<!DOCTYPE html>
<html>
<head>


<style>
  main
  {
    margin: 5px;
  }
  .connectError
  {color:red;}



</style>

<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>



<main>
 
    <h1>Connexion</h1>
  
    <form action="home" method="POST">
      <table>
        <tr><td title="Saisir votre login">Login : </td><td><input name="login" required size="20" minlength="5" maxlength="10" type="text" placeholder="Saisir votre login"></td></tr>
        <tr><td>Password :</td><td> <input name="password" required title="Format du message" type="password"  minlength="5" placeholder="Saisir password" ></td></tr>
      </table>
      <input  class="btn btn-outline-primary" value="Se Connecter" type="submit">
    </form>
    <div class="connectError">${error}</div>
    <a href="inscription.html">Inscription </a>
 
</main>


</body>
</html>
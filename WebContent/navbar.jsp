<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">Accueil</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Adhérents <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="Controleur?action=ajouterAdherent"><font
				face="Arial">Ajout Adhérent</font></a></li>
			<li><a href="Controleur?action=listerAdherent"><font
				face="Arial">Lister les adhérents</font></a><font face="Arial"> </font></li>	
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Oeuvres <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <li><a href="Controleur?action=reserverOeuvres"><font
				face="Arial">Réserver une oeuvre</font></a><font face="Arial"> </font></li>	
            <li><a href="Controleur?action=listerOeuvres"><font
				face="Arial">Lister les oeuvres</font></a><font face="Arial"> </font></li>	
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-right" method="post" action="Controleur?action=recherche" role="search">
        <div class="form-group">
          <input type="text" class="form-control" name="recherchetxt" placeholder="Oeuvre ou Adhérent">
        </div>
        <button type="submit" class="btn btn-default">Chercher</button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
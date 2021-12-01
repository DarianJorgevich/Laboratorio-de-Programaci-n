const divHeader = document.getElementById("headerTag");

cargarHeader(divHeader);

function cargarHeader(divHeader) {
    divHeader.innerHTML = `
    <div class="logoHeader">
    <div><img class="logoImg" src="img/logo_extendido2.jpg" rounded-images></div>
    <div id="search"></div>
  </div>

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href="index.html">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Servicios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Insumos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="productos.html">Todos los productos</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button"
              data-bs-toggle="dropdown" aria-expanded="false">
              Ofertas
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Ofertas nuevas</a></li>
              <li><a class="dropdown-item" href="#">Ofertas dia de la madre</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contacto.html">Contacto</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>`;
}


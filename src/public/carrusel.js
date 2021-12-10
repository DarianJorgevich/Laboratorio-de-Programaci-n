var carr = document.getElementById("carrusel");

extraerElementos(4, 0, carr);

//funcion que va a extraer elementos de una API
function extraerElementos(cantidad, desde, unDiv) {
  //le pedimos a la API la cantidad de elem que necesitamos 
  fetch(`http://localhost:3000/api/productos?cantidad=${cantidad}&desde=${desde}&tipo=carrusel`) 
    .then((res) => {
      return res.json();
    })
    .then((post) => {
      ubicarCarrusel(post, unDiv, post.length);
    })
}

//esta funcion muestra la presentacion "carrusel" en nuestra pagina de inicio
//Vamos a utilizar la herramienta Carrousel que nos brinda Bootstrap
function ubicarCarrusel(elem, unDiv, cantidad) {
    var auxIndicadores = ``;
    var auxItems = ``; 
//verificación para evitar que intente leer parametros de un null
if (unDiv != null) { 
    //recorremos todo el Json y creamos los botones de abajo y las imagenes del carrusel
    for (let i = 0; i < cantidad; i++){
      if(i == 0){
          auxIndicadores+=` <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>`;
          auxItems+=  `
          <div class="carousel-item active">
            <img src="${elem[i].ubicacion}" alt="${elem[i].alt}" class="img-fluid" style="width:100%">
          </div>`
      }
      else{
          auxIndicadores+= `<button type="button" data-bs-target="#demo" data-bs-slide-to="${i}"></button>`;
          auxItems+= `
          <div class="carousel-item">
            <img src="${elem[i].ubicacion}" alt="${elem[i].alt}" class="img-fluid" style="width:100%">
          </div>`
      }
  }
 
  //Variable que contiene los botones indicadores
  var indicadores= `
  <!-- indicadores -->
      <div class="carousel-indicators"> ${auxIndicadores} </div>`;

  //Variable que contiene todas las imagenes del carrusel
  var items = `
    <!-- las imagenes del carousel-->
     <div class="carousel-inner"> 
      ${auxItems} 
    </div>`;

 //botones de izquierda a derecha 
   var botones =
     `<!-- los controles de izquierda a derecha -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
      <span class="carousel-control-next-icon"></span>
    </button>`;

   //unimos todo el codigo creado en el div del parametro
    unDiv.innerHTML=`  
    <!-- Carousel -->
    <div id="demo" class="carousel slide" data-bs-ride="carousel"> ${indicadores} ${items} ${botones}`;

    
  }
}

var con = 0;
var divIndex = document.getElementById("cardDiv");
const cantArticulosXPantalla = 12;

getRango(4,0);

function getRango(cantidad, desde) {
  fetch(`http://localhost:3000/api/productos?cantidad=${cantidad}&desde=${desde}`) //aca deberia pedirle el json al servidor o la cantidad de elementos que necesita
  .then((res) => {
    return res.json();
  })
  .then((post) => {
    mostrarCartas(post, divIndex, 0, cantidad);
  })
}

/*
function getRango(cantidad, desde) {
  const http = new XMLHttpRequest();
  const idProd = 1;
  const url = `http://localhost:3000/api/productos?cantidad=${cantidad}&desde=${desde}`;

  http.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      console.log('Datos obtenidos con getRango(): ',this.response);
      mostrarCartas(this.response, divIndex, 0, cantidad)
    }
  }
  http.open("GET", url);
  http.send();
}*/

//esta funcion muestra las cartas de el json
//como parametros esta el arreglo de productos, el div que queremos, el primer numero del arreglo y el ultimo que querramos
function mostrarCartas(productos, unDiv, desde, hasta) {
  for (desde; desde < hasta; desde++) {
    unDiv.innerHTML += ` 
            <div class="card">
            <img src="${productos[desde].ubicacion}" alt=${productos[desde].alt} class="card-img-top">
            <div class="card-body">
              <h5 class="card-title">${productos[desde].titulo}</h5>
              <p class="card-text">${productos[desde].desc}</p>
              <a href="#" class="btn btn-primary">Mas info+</a>
            </div>
          </div>
            `

  }
}





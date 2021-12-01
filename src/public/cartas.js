var divIndex = document.getElementById("cardDiv");
var divProdu = document.getElementById("contenidoProd");

mostrarCartas(4,0,divIndex);
mostrarCartas(5,0,divProdu); 

function mostrarCartas(cantidad, desde, unDiv) { //funcion que va a mostrar una cantidad de cards desde algun punto del arreglo
  fetch(`http://localhost:3000/api/productos?cantidad=${cantidad}&desde=${desde}`) //le pedimos a la API la cantidad de productos que necesitamos
  .then((res) => {
    return res.json();
  })
  .then((post) => {
    ubicarCartas(post, unDiv, 0, cantidad);
  })
}

//esta funcion muestra las cartas de el json
//como parametros esta el arreglo de productos, el div que queremos, el primer numero del arreglo y el ultimo que querramos
function ubicarCartas(productos, unDiv, desde, hasta) {
  unDiv.innerHTML='';
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





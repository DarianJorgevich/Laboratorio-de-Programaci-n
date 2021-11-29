var con = 0;
var divIndex = document.getElementById("cardDiv");
const cantArticulosXPantalla = 12;


fetch('http://localhost:3000/api/productos') //aca deberia pedirle el json al servidor o la cantidad de elementos que necesita
  .then((res) => {
    return res.json();
  })
  .then((post) => {
    mostrarCartas(post,divIndex,0,4);
  })

  //esta funcion muestra las cartas de el json
  //como parametros esta el arreglo de productos, el div que queremos, el primer numero del arreglo y el ultimo que querramos
  function mostrarCartas(productos, unDiv, desde, hasta){
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




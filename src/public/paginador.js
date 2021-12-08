const divContenido = document.getElementById("contenidoProd");

var pagActual = 0;
var cantPaginas;
const itemsPorPag = 4;
var ultimoItemActual = 0;

configPaginas();    //configura cantidad de paginas y botones

boton(1);   //Para cargar la pagina inicialmente

function prev() {
    var proxPag = pagActual - 1;
    if (proxPag <= 0) {
        proxPag = 1;            //Para evitar que se pase de rango
    }
    boton(proxPag);
}
function next() {
    var proxPag = pagActual + 1;
    if (proxPag > cantPaginas) {
        proxPag = cantPaginas;  //Para evitar que se pase de rango
    }
    boton(proxPag);
}

function boton(idPagina) {
    if (idPagina != pagActual) {
        pagActual = idPagina;
        ultimoItemActual = (pagActual - 1) * itemsPorPag; //Para setear el inicio desde donde tomar los datos
        mostrarCartas(itemsPorPag, ultimoItemActual, divContenido);
        ultimoItemActual = ultimoItemActual + itemsPorPag;
    }
}

function configPaginas() { //funcion que va a mostrar una cantidad de cards desde algun punto del arreglo
    fetch(`http://localhost:3000/api/productos?numTotal=0&tipo=producto`)
        .then((res) => {
            return res.json();
        })
        .then((post) => {
            console.log('total de productos: ', post);
            setCantPaginas(post);
            setBotonesEnHtml(cantPaginas);
        })
}
function setCantPaginas(total) {
    cantPaginas = total / itemsPorPag;
    cantPaginas = Math.ceil(cantPaginas);
}
function setBotonesEnHtml(paginas) {
    var unDiv = document.getElementById("botonesPag");
    for (i = 1; i <= paginas; i++) {
        unDiv.innerHTML +=
            `<li class="page-item" aria-current="page">
        <button class="page-link" onclick=boton(${i})>${i}</button>`
    }
}
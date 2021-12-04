const bot1 = document.getElementById("contBoton1");
const bot2 = document.getElementById("contBoton2");
const bot3 = document.getElementById("contBoton3");
const botPrev = document.getElementById("contPrev");
const botNext = document.getElementById("contNext");
const divContenido = document.getElementById("contenidoProd");

var pagActual = 1;
const cantPaginas = 3;
const itemsPorPag = 5;
var ultimoItemActual = 0;

boton1();   //Para cargar la pagina inicialmente

//--------------Prueba mejora paginador
pedirTotal();
//--------------FIN Prueba mejora paginador


function boton1() {
    pagActual = 1;
    ultimoItemActual = (pagActual - 1) * itemsPorPag; //Para setear el inicio desde donde tomar los datos 
    configBotones();
    mostrarCartas(itemsPorPag, ultimoItemActual, divContenido);
    ultimoItemActual = ultimoItemActual + itemsPorPag;
}
function boton2() {
    pagActual = 2;
    ultimoItemActual = (pagActual - 1) * itemsPorPag; //Para setear el inicio desde donde tomar los datos 
    configBotones();
    mostrarCartas(itemsPorPag, ultimoItemActual, divContenido);
    ultimoItemActual = ultimoItemActual + itemsPorPag;
}
function boton3() {
    pagActual = 3;
    ultimoItemActual = (pagActual - 1) * itemsPorPag; //Para setear el inicio desde donde tomar los datos 
    configBotones();
    mostrarCartas(itemsPorPag, ultimoItemActual, divContenido);
    ultimoItemActual = ultimoItemActual + itemsPorPag;
}

function prev() {
    switch (pagActual) {
        case 1:
            break;
        case 2:
            boton1();
            break;
        case 3:
            boton2();
            break;
        default:
            break;
    }
}
function next() {
    switch (pagActual) {
        case 1:
            boton2();
            break;
        case 2:
            boton3();
            break;
        case 3:
            break;
        default:
            break;
    }
}

function configBotones() {
    //Funcion para configurar la habilitacion/deshabilitacion de botones
    switch (pagActual) {
        case 1:
            bot1.className = "page-item active";
            bot2.className = "page-item";
            bot3.className = "page-item";
            botPrev.className = "page-item disabled";
            botNext.className = "page-item";
            break;
        case 2:
            bot1.className = "page-item";
            bot2.className = "page-item active";
            bot3.className = "page-item";
            botPrev.className = "page-item";
            botNext.className = "page-item";
            break;
        case 3:
            bot1.className = "page-item";
            bot2.className = "page-item";
            bot3.className = "page-item active";
            botPrev.className = "page-item";
            botNext.className = "page-item disable";
            break;
        default:
            break;
    }
}

//--------------Prueba mejora paginador
function pedirTotal() { //funcion que va a mostrar una cantidad de cards desde algun punto del arreglo
    fetch(`http://localhost:3000/api/productos?numTotal=0`)
        .then((res) => {
            return res.json();
        })
        .then((post) => {
            //ubicarCartas(post, unDiv, 0, cantidad);
            console.log('total de productos: ',post);
        })
}
//--------------FIN Prueba mejora paginador
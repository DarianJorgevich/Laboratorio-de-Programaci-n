const bot1 = document.getElementById("contBoton1");
const bot2 = document.getElementById("contBoton2");
const botPrev = document.getElementById("contPrev");
const botNext = document.getElementById("contNext");

var pagActual = 1;
const itemsPorPag = 5;
var ultimoItemActual = 0;

boton1();

/*function boton1(cantidad, desde) {
    bot1.className = "page-item active";
    bot2.className = "page-item";
    botPrev.className = "page-item disabled";
    botNext.className = "page-item";
    mostrarCartas(cantidad, desde, document.getElementById("contenidoProd"));
}*/
function boton1() {
    bot1.className = "page-item active";
    bot2.className = "page-item";
    botPrev.className = "page-item disabled";
    botNext.className = "page-item";
    ultimoItemActual = 0;
    mostrarCartas(itemsPorPag, ultimoItemActual, document.getElementById("contenidoProd"));
    ultimoItemActual = ultimoItemActual + itemsPorPag;
    console.log('ultimo item actual despues de boton 1: ', ultimoItemActual);
}

/*function boton2(cantidad, desde) {
    bot1.className = "page-item";
    bot2.className = "page-item active";
    botPrev.className = "page-item";
    botNext.className = "page-item disabled";
    mostrarCartas(cantidad, desde, document.getElementById("contenidoProd"));
}*/
function boton2() {
    bot1.className = "page-item";
    bot2.className = "page-item active";
    botPrev.className = "page-item";
    botNext.className = "page-item disabled";
    mostrarCartas(itemsPorPag, ultimoItemActual, document.getElementById("contenidoProd"));
    ultimoItemActual = ultimoItemActual + itemsPorPag;
    console.log('ultimo item actual despues de boton 2: ', ultimoItemActual);
}

function prev() {
    if (bot2.className == "page-item active") {
        boton1();
    }
    botPrev.className = "page-item disabled";
    botNext.className = "page-item";
}
function next() {
    if (bot1.className == "page-item active") {
        boton2();
    }
    botPrev.className = "page-item";
    botNext.className = "page-item disabled";
}
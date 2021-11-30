const bot1 = document.getElementById("contBoton1");
const bot2 = document.getElementById("contBoton2");
const botPrev = document.getElementById("contPrev");
const botNext = document.getElementById("contNext");

function boton1(cantidad, desde) {
    bot1.className = "page-item active";
    bot2.className = "page-item";
    botPrev.className = "page-item disabled";
    botNext.className = "page-item";
    mostrarCartas(cantidad, desde, document.getElementById("contenidoProd"));
}
function boton2(cantidad, desde) {
    bot1.className = "page-item";
    bot2.className = "page-item active";
    botPrev.className = "page-item";
    botNext.className = "page-item disabled";
    mostrarCartas(cantidad, desde, document.getElementById("contenidoProd"));
}
function prev() {
    if (bot2.className == "page-item active") {
        boton1(5, 0);
    }
    botPrev.className = "page-item disabled";
    botNext.className = "page-item";
}
function next() {
    if (bot1.className == "page-item active") {
        boton2(5, 5);
    }
    botPrev.className = "page-item";
    botNext.className = "page-item disabled";
}
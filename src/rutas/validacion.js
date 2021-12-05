const _ = require('underscore');
const fs = require('fs');

function validarProducto(titulo, desc, ubicacion, alt) {
    //se valida los campos que tiene el producto
    //tiene que estar correctos todos los campos: titulo, descripcion del producto, ubicacion de la foto y alt.
    var esCorrecto = true;
    if (!titulo || !desc || !ubicacion || !alt) {
        esCorrecto = false;
    }
    return esCorrecto;
}

function validarID(unID, productos) {
    //metodo para validar un ID en el JSON productos
    //devuelve la posicion del arreglo donde esta el ID
    //si el ID es -1 quiere decir que no lo encontro (el ID son enteros positivos)
    var pos = -1;
    if (validarNumero(unID) && unID >= 0) {
        _.each(productos, (producto, i) => {
            //por cada producto va verificando si su id es el mismo que el parametro
            if (producto.id == unID) {
                pos = i;
            };
        });
    }

    return pos;
};

function validarNumero(num) {
    //funcion que verifica si un string pasado por parametro es un numero
    return !isNaN(parseInt(num, 10));
}



module.exports = {
    validarProducto,
    validarID,
    validarNumero
}
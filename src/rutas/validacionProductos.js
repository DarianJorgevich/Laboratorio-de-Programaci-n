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
    //si el ID es -1 quiere decir que no lo encontro
    var pos = -1;
    _.each(productos, (producto, i) => {
        //por cada producto va verificando si su id es el mismo que el parametro
        if (producto.id == unID) {
            pos = i;
        };
    });
    return pos;
}

//esta funcion escribe los cambios en el arreglo de productos a memoria
//retorna un valor booleando que nos dice si fue escrito o no con exito
function escritura(productos) {
    var correcto = true;
    const json_productos = JSON.stringify(productos);
    fs.writeFile('src/productos.json', json_productos, (err) => {
        if (err) {
            correcto = false;
            throw err;
        }
    });
    return correcto;
}
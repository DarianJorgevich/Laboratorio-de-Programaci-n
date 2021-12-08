
const fs = require('fs');



function escribirArreglo(productos, req){
    const id = productos.length + 1; //asignamos el ID del nuevo producto
    const newProducto = { ...req, id }; //el nuevo producto va a tener el body de lo pasado por req + el id
    productos.push(newProducto); //colocaos el nuevo producto en el arreglo de productos

    //escribimos en memoria el nuevo JSON, en caso de error se notifica
    if (escritura(productos)) {
        console.log("El dato se ha escrito en el archivo");
        console.log(newProducto);
    }
    
}

function modificarArreglo(productos, pos, titulo, desc, ubicacion, alt, tipo){
    //funcion para modificar un elemento del arreglo
    //retorna true si se pudo efectuar todo el metodo correctamente
    var correcto = false;
    productos[pos].titulo = titulo;
    productos[pos].desc = desc;
    productos[pos].ubicacion = ubicacion;
    productos[pos].alt = alt;
    productos[pos].tipo = tipo;

    //escribimos en memoria el nuevo JSON, en caso de error se notifica
    if (escritura(productos)) {
        correcto=true;
    }
    return correcto;
}


function escritura(productos) {
    //esta funcion escribe los cambios en el arreglo de productos a memoria
    //retorna un valor booleando que nos dice si fue escrito o no con exito
    var correcto = true;
    const json_productos = JSON.stringify(productos);
    fs.writeFileSync('src/productos.json', json_productos, (err) => {
        if (err) {
            correcto = false;
            throw err;
        }
    });
    return correcto;
};


module.exports = {
    escribirArreglo,
    modificarArreglo,
    escritura
};

const { Router } = require('express');
const router = Router();
const _ = require('underscore');
const fs = require('fs');

const json_productos = fs.readFileSync('src/productos.json', 'utf-8'); //leemos el Json
let productos = JSON.parse(json_productos);

//Metodo GET por ID
router.get('/:id', (req, res) => {
    const { id } = req.params;
    var pos = validarID(id); //verificamos si existe el ID
    if (pos == -1) {
        res.status(404).json({ error: 'No existe el ID' });
    }
    else {
        res.json([productos[pos]]);
    }
});

//Metodo GET por rango
router.get(['/', '/:cantidad' & '/:desde'], (req, res) => { //envia el json
    console.log('Parametros query: ', JSON.stringify(req.query));
    const cantProd = req.query.cantidad;
    const desdeProd = req.query.desde;
    if (cantProd && desdeProd) {
        console.log('Se deberia enviar un rango desde:', desdeProd, ' - La cantidad de:', cantProd)
        res.json((productos).slice(desdeProd, JSON.parse(desdeProd) + JSON.parse(cantProd)));
    } else {
        res.json(productos);
        console.log('Se envio: ', productos);
    }
});



router.post('/', async (req, res) => {
    const { titulo, desc, ubicacion, alt } = req.body;
    if (validarProducto(titulo, desc, ubicacion, alt)) { //validacion 
        const id = productos.length + 1; //asignamos el ID del nuevo producto
        const newProducto = { ...req.body, id }; //el nuevo producto va a tener el body de lo pasado por req + el id
        productos.push(newProducto); //colocaos el nuevo producto en el arreglo de productos

        //escribimos en memoria el nuevo JSON, en caso de error se notifica
        if (escritura()) {
            console.log("El dato se ha escrito en el archivo");
            console.log(newProducto);
            res.send(newProducto);
        }
    }
    else {

        res.status(500).json({ error: 'Error al validar datos, recuerde que debe cargar titulo, desc, ubicacion y alt' });
    }
})

router.put('/:id', async (req, res) => {
    const { id } = req.params;
    var pos = validarID(id);
    //validamos el ID
    if (pos == -1) {
        res.status(404).json({ error: 'No existe el ID' });
    }
    else {
        const { titulo, desc, ubicacion, alt } = req.body;
        //validamos los datos, si esta todo bien, se modifica el elemento
        if (validarProducto(titulo, desc, ubicacion, alt)) {
            productos[pos].titulo = titulo;
            productos[pos].desc = desc;
            productos[pos].ubicacion = ubicacion;
            productos[pos].alt = alt;

            //escribimos en memoria el nuevo JSON, en caso de error se notifica
            if (escritura()) {
                res.json(productos);
            }

        }
        else {
            res.status(500).json({ error: 'Error al validar datos, recuerde que debe cargar titulo, desc, ubicacion y alt' });
        }
    }
})

function validarProducto(titulo, desc, ubicacion, alt) {
    //se valida los campos que tiene el producto
    var esCorrecto = true;
    if (!titulo || !desc || !ubicacion || !alt) {
        esCorrecto = false;
    }
    return esCorrecto;
}

function validarID(unID) {
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
function escritura() {
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


module.exports = router;
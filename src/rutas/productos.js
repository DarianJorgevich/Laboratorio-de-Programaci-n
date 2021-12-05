
const { Router } = require('express');
const router = Router();
const _ = require('underscore');
const fs = require('fs');

let vali = require('./validacion.js'); //variable que nos dan los metodos de validacion de datos 
let mani = require('./manipulacion.js'); //variable que nos dan los metodos de creacion y modificacion de datos 
const json_productos = fs.readFileSync('src/productos.json', 'utf-8'); //leemos el Json
let productos = JSON.parse(json_productos); 

//Metodo GET por ID
router.get('/:id', (req, res) => {
    const { id } = req.params;
    //verificamos si existe el ID y nos devuelve la posicion en el arreglo productos
    var pos = vali.validarID(id, productos); 
    if (pos == -1) {
        res.status(404).json({ error: 'No existe el ID' });
    }
    else {
        res.json([productos[pos]]);
    }
});

//Metodo GET por rango
router.get(['/', '/:cantidad' & '/:desde', '/:numTotal'], (req, res) => { //envia el json
    const cantProd = req.query.cantidad;
    const desdeProd = req.query.desde;
    const totalProd = req.query.numTotal;
    if(cantProd && desdeProd){
        if (vali.validarNumero(cantProd) && vali.validarNumero(desdeProd)) {
            //console.log('Se deberia enviar un rango desde:', desdeProd, ' - La cantidad de:', cantProd)
            res.json((productos).slice(desdeProd, JSON.parse(desdeProd) + JSON.parse(cantProd)));
        }
        else{
            res.status(400).json({ error: 'Error al validar datos, recuerde que cantidad y desde son numeros enteros' });
        }
    }
    else {
        if (totalProd) {
            //si se consulta la longitud
            if(vali.validarNumero(totalProd)){
                res.json(productos.length);
            }else{
                res.status(400).json({ error: 'Error al validar datos, recuerde que el numTotal es un numero' });
            }
        } else {
            //si es un get comun se envian todos los elementos del json
            res.json(productos);
            //console.log('Se envio: ', productos);
        }
    }
});



router.post('/', (req, res) => {
    const { titulo, desc, ubicacion, alt } = req.body;
    //validacion 
    if (vali.validarProducto(titulo, desc, ubicacion, alt)) { 
        mani.escribirArreglo(productos, req.body);
        //el elemento que se crea siempre es el ultimo del arreglo.
        var ultimoElem= productos.length - 1; 
        res.json(productos[ultimoElem]);
    }
    else {
        res.status(400).json({ error: 'Error al validar datos, recuerde que debe cargar titulo, desc, ubicacion y alt' });
    }
})

router.put('/:id', (req, res) => {
    const { id } = req.params;
    var pos = vali.validarID(id, productos);
    //validamos el ID
    if (pos == -1) {
        res.status(404).json({ error: 'No existe el ID' });
    }
    else {
        const { titulo, desc, ubicacion, alt } = req.body;
        //validamos los datos, si esta todo bien, se modifica el elemento
        if (vali.validarProducto(titulo, desc, ubicacion, alt)) {
            //verificamos si se pudo modificar con exito
            if (mani.modificarArreglo(productos,pos,titulo, desc, ubicacion, alt)){ 
                res.json(productos[pos]);
            }
        }
        else {
            res.status(400).json({ error: 'Error al validar datos, recuerde que debe cargar titulo, desc, ubicacion y alt' });
        }
    }
})

module.exports = router;
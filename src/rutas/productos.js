
const { Router } = require('express');
const router = Router();
const _ = require('underscore');
const fs = require('fs');

const json_productos = fs.readFileSync('src/productos.json', 'utf-8'); //leemos el Json
let productos = JSON.parse(json_productos);

/*router.get(['/','/:id'], (req, res) => { //envia el json
    var idProd = req.params.id;
    console.log('id parametro: ',idProd);
    res.json(productos[idProd]);
    //console.log('Se envio: ', productos);
});*/
//Metodo GET por id. Si se ingresa mal id, se envian todos los elementos
router.get(['/', '/:id', '/:cantidad' & '/:desde'], (req, res) => { //envia el json
    console.log('Parametros query: ', JSON.stringify(req.query));
    const idProd = req.query.id;
    const cantProd = req.query.cantidad;
    const desdeProd = req.query.desde;
    if (idProd && !cantProd && !desdeProd) {    //Fue la forma que se me ocurrio de verificar que solo manden id
        res.json(productos[idProd]);
    } else {
        if (cantProd && desdeProd && !idProd) {
            console.log('Se deberia enviar un rango desde:',desdeProd,' - La cantidad de:',cantProd)
            res.json((productos).slice(desdeProd,JSON.parse(desdeProd)+JSON.parse(cantProd)));
        } else {
            res.json(productos);
            console.log('Se envio: ', productos);
        }
    }
});


router.post('/', async (req, res) => {
    const { titulo, desc, ubicacion, alt } = req.body;
    if (titulo && desc && ubicacion && alt) { //validacion (ACA FIJATE DE HACERLO EN OTRA CLASE COSA O USA LIBRERIAS DE VALIDACION)
        const id = productos.length + 1;
        const newProducto = { ...req.body, id };
        productos.push(newProducto);
        const json_productos = JSON.stringify(productos);
        fs.writeFile('src/productos.json', json_productos, (err) => {
            if (err) {
                throw err;
            }
        });
        console.log("El dato se ha escrito en el archivo");
        console.log(newProducto);
    }
    else {

        res.status(500).json({ error: 'hubo un error, faltan datos' });
    }
})

router.put('/:id', async (req, res) => {
    const { id } = req.params;
    const { titulo, desc, ubicacion, alt } = req.body;
    if (titulo && desc && ubicacion && alt) {
        _.each(productos, (producto, i) => {
            if (producto.id == id) {
                producto.titulo = titulo;
                producto.desc = desc;
                producto.ubicacion = ubicacion;
                producto.alt = alt;
            };
        });
        const json_productos = JSON.stringify(productos);
        fs.writeFile('src/productos.json', json_productos, (err) => {
            if (err) {
                throw err;
            }
        });
        res.json(productos);
    }
    else {
        res.status(500).json({ error: 'hubo un error' });
    }
})

module.exports = router;
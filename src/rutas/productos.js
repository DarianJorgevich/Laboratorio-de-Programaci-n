
const { Router } = require('express');
const router = Router();
const _ = require('underscore');
const fs = require('fs');

const json_productos = fs.readFileSync('src/productos.json', 'utf-8'); //leemos el Json
let productos = JSON.parse(json_productos);

//Metodo GET por ID
router.get('/:id', (req, res) => {
    const { id } = req.params;
    var hay = false;
    //acá deberia validad de que el id sea un numero
    _.each(productos, (producto, i) => {
        if (producto.id == id) {
            hay = true;
            res.json(producto);
        }
    });
    if (!hay) {
        res.status(404).json({ error: 'No existe el ID' });
    }
});
//Metodo GET por rango
router.get(['/','/:cantidad' & '/:desde'], (req, res) => { //envia el json
    console.log('Parametros query: ', JSON.stringify(req.query));
    const cantProd = req.query.cantidad;
    const desdeProd = req.query.desde;
    if (cantProd && desdeProd) {
        console.log('Se deberia enviar un rango desde:', desdeProd, ' - La cantidad de:', cantProd)
        res.json((productos).slice(desdeProd, JSON.parse(desdeProd) + JSON.parse(cantProd)));
    }else{
        res.json(productos);
        console.log('Se envio: ', productos);
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
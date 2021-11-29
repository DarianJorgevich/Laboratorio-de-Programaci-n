const { Router } = require('express');
const router = Router();
const path = require('path');

//data
const productos = require('../public/productos.json');
//console.log(productos);

router.get('/', (req, res) => {
    //res.send("---Productos---");
    res.json(productos);
});

module.exports = router;
var express = require('express');
var router = express.Router();
var path = require('path');

//ruta pagina inicial
router.get('/', function (req, res) {
    res.sendFile(path.resolve(__dirname, 'index.html'));
});
router.get('/index.html', function (req, res) {
    res.sendFile(path.resolve(__dirname, 'index.html'));
});

//ruta pagina contacto
router.get('/contacto.html', function (req, res) {
    res.sendFile(path.resolve(__dirname, 'contacto.html'));
});

router.post('/', function (req, res) {
    res.send('POST route on things.');
});

//exporta este ROUTER en nuestro index.js
module.exports = router;
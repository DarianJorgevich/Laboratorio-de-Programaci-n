var express = require('express');   //importa express en nuestro archivo
var app = express();                //la variable app nos da acceso a express
const PORT = 3000;                  //numero de puerto por el que el servidor escuchará

/*
app.get('/', function(req, res){
   res.send("Hello world!");
});*/

//----------------test
var things = require('./things.js');
//index.js y things.js deben estar en la misma carpeta
app.use('/things', things)

var paginas = require('./paginas.js');
//index.js y things.js deben estar en la misma carpeta
app.use('/paginas', paginas)
//----------------test



app.listen(
    PORT,
    () => console.log(`it's alive on http://localhost:${PORT}`)    
);
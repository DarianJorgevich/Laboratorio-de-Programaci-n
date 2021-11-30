const express = require('express');
const app = express();
const morgan = require('morgan'); 
const path = require("path");
const { Router, application, response } = require('express');
const router = Router();

//configuraciones
app.set('port',process.env.PORT || 3000);
app.set('json spaces',2);

//middlewares
app.use(morgan('dev')); //leer los mensajes http
app.use(express.urlencoded({extended: false}));
app.use(express.json());
app.use(express.static('public'));


//ruta principal

//rutas
app.use('/',require('./rutas/home'));
app.use('/api/productos',require('./rutas/productos'));

//static 
app.use(express.static(path.join(__dirname,'public')));

//empezando el servidor
app.listen(3000, ()=> {
    console.log(`server on port ${app.get('port')}`); //app lo podemos obtener desde cualquier lado de nuestra aplicacion 
})
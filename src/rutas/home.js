const { Router } = require('express');
const router = Router();
const path = require('path');
var asd;

router.get('/', (req, res) => {
    res.sendFile(path.resolve("src","public", "index.html"));
});

router.get('/home', (req, res) => {
    res.sendFile(path.resolve("src", "public", "index.html"));
});

module.exports = router;
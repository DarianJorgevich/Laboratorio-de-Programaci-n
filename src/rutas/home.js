const { Router } = require('express');
const router = Router();
const path = require('path');

router.get('/', (req, res) => {
    res.sendFile(path.resolve("public", "index.html"));
});

router.get('/home', (req, res) => {
    res.sendFile(path.resolve("public", "index.html"));
});

module.exports = router;
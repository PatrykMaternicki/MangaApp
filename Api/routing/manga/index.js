const manga = require('express').Router();
const get = require('./get');
const post = require('./post');
const put = require('./put');
const del = require('./delete');

manga.get('/:id', get);
manga.post('/', post);
manga.put('/:id', put);
manga.delete('/:id', del);
module.exports = manga;

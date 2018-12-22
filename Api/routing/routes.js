const routes        = require('express').Router();
const MangaRouting   = require('./manga');


routes.use('/manga', MangaRouting);

module.exports = routes;

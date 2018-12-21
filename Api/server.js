// server.js
var express         = require('express');
var app             = express();
var bodyParser      = require('body-parser');
var Routes          = require('./routing/routes');
var cors            = require('cors')
app.use(cors());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var port = process.env.PORT || 8080;

Routes.use(function(req, res, next) {
  console.log('Request do', req.originalUrl);
  console.log('Parametry', req.params);
  console.log('Podane parametry', req.body);
  console.log('Wyłowanie requestu po', req.method);
  next();
});

app.use('/api', Routes);

app.listen(port);
console.log('Api manga is running ' + port);

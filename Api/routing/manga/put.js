const MangaRepository = require('../../repository/MangaRepository');

module.exports = (req, res) => {
  let repository = new MangaRepository();
  repository.update(req.params.id, req.body);
  res.status(200).json({status: true});
};

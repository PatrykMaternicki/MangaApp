const MangaRepository = require('../../repository/MangaRepository');

module.exports = (req, res) => {
  let repository = new MangaRepository();
  repository.remove(req.params.id);
  res.status(200).json({data: 'success'});
};

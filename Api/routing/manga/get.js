const MangaRepository = require('../../repository/MangaRepository');

module.exports = (req, res) => {
  let repository = new MangaRepository();
  res.status(200).json({data: repository.read(req.params['id'])});
};

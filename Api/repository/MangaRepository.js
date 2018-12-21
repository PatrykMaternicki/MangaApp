const Db = require('../db');

class MangaRepository {
  constructor() {
    this.currentId = Db().get().length;
  }

  create(data) {
    this.currentId = this.currentId + 1;
    Db.insert({
      'id' : this.currentId,
      'title' : data.title,
      'autor': data.autor,
      'category': data.category,
    })
  }

  read(id) {
    return Db({"id": Number.parseInt(id)}).first();
  }

  update(id, data) {
    console.log(data);
    Db({'id': Number.parseInt(id)}).update({
      'title' : data.title,
      'autor': data.autor,
      'category': data.category,
    })
  }

  remove(id) {
    Db({'id': Number.parseInt(id)}).remove();
  }
}

module.exports = MangaRepository;

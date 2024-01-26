
-- rah ray
db.options.insertOne({idoptions: 1, nomoptions: "Airbags", idtype: 1})

-- rah bdb
db.options.insertMany([
 {idoptions: 2, nomoptions: "Caméra de recul", idtype: 1},
 {idoptions: 2, nomoptions: "Freins ABS", idtype: 1},
 {idoptions: 2, nomoptions: "Toit ouvrant", idtype: 2},
 {idoptions: 2, nomoptions: "Système audio haut de gamme", idtype: 2},
 {idoptions: 2, nomoptions: "Système de climatisation automatique", idtype: 2}
])

-- select
db.options.find()

-- select nomoptions, idtype -> 1 : champ inclus, 0 : exclu
db.options.find({}, { nomoptions: 1, idtype: 1 })

-- where
db.options.find({ idtype: 1 })
-- >
db.options.find({ idtype: { $gt: 1 } })
-- >=
 db.options.find({ idtype: { $gte: 1 } })
--  <
 db.options.find({ idtype: { $lt: 1 } })
-- <=
 db.options.find({ idtype: { $lte: 1 } })

--  update where idtype=1 voalohany
db.options.updateOne({ idtype: 1 }, { $set: { nomoptions: "New Option" } })
-- ze rehetra idtype=1
db.options.updateMany({ idtype: 1 }, { $set: { nomoptions: "New Option" } })
-- repmlace un document (ligne ray iny)
db.options.replaceOne({ idtype: 1 }, { idoptions: 1, nomoptions: "New look", idtype: 1 })



db.product.insertOne({idproduct: 1, nom: "bague"})
db.product.insertOne({idproduct: 2, nom: "collier"})
db.product.insertOne({idproduct: 1, nom: "sac"})


db.annonce.updateOne({ idannonce: "39da152c" }, { $set: { idvoiture: "ad447b93" } })
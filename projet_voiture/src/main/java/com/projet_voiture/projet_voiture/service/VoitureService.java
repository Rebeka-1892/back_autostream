package com.projet_voiture.projet_voiture.service;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.projet_voiture.projet_voiture.modele.Voiture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VoitureService {
    private final MongoCollection<Document> VoitureCollection;

    public VoitureService(MongoClient mongoClient, @Value("${databaseName}") String databaseName,
            @Value("${voiture}") String collectionName) {
        this.VoitureCollection = mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public FindIterable<Document> findAll() {
        return VoitureCollection.find();
    }

    public Voiture insert(Voiture Voiture) {
        Document doc = new Document();
        doc.append("idvoiture", Voiture.getIdvoiture());
        doc.append("nbplace", Voiture.getNbplace());
        doc.append("nbporte", Voiture.getNbporte());
        doc.append("kilometrage", Voiture.getKilometrage());
        doc.append("cylindre", Voiture.getCylindre());
        doc.append("puissance", Voiture.getPuissance());
        doc.append("fumeur", Voiture.getFumeur());
        doc.append("datesortie", Voiture.getDatesortie());
        doc.append("idconduite", Voiture.getIdconduite());
        doc.append("idmodele", Voiture.getIdmodele());
        doc.append("iddrivetype", Voiture.getIddrivetype());
        doc.append("idtransmission", Voiture.getIdtransmission());
        doc.append("idenergie", Voiture.getIdenergie());
      
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().upsert(true).returnDocument(ReturnDocument.AFTER);
        Document result = VoitureCollection.findOneAndReplace(Filters.eq("idvoiture", Voiture.getIdvoiture()), doc, options);
      
        return new Voiture(result.getInteger("idvoiture"), result.getInteger("nbplace"), result.getInteger("nbporte"), result.getDouble("kilometrage"), result.getDouble("cylindre"), result.getDouble("puissance"),
        result.getInteger("fumeur"), result.getDate("datesortie"), result.getInteger("idconduite"), result.getInteger("idmodele"), result.getInteger("iddrivetype"), result.getInteger("idtransmission"),
        result.getInteger("idenergie"));
    }
      

    public Document findById(int idVoiture) {
        return VoitureCollection.find(new Document("idvoiture", idVoiture)).first();
    }

    public void updateVoiture(int idVoiture, Document updatedVoiture) {
        VoitureCollection.updateOne(new Document("idvoiture", idVoiture), new Document("$set", updatedVoiture));
    }

    public void deleteVoiture(int idVoiture) {
        VoitureCollection.deleteOne(new Document("idvoiture", idVoiture));
    }
}

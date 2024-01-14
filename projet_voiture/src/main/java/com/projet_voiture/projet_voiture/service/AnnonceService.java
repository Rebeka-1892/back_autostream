package com.projet_voiture.projet_voiture.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.projet_voiture.projet_voiture.modele.Annonce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {
    private final MongoCollection<Document> AnnonceCollection;

    public LocalDateTime convertStringToLocalDateTime(String dateStr) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return LocalDateTime.parse(dateStr, formatter);
   }

    public AnnonceService(MongoClient mongoClient, @Value("${databaseName}") String databaseName,
            @Value("${annonce}") String collectionName) {
        this.AnnonceCollection = mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public FindIterable<Document> findAll() {
        return AnnonceCollection.find();
    }

    public Annonce insert(Annonce Annonce) {
        Document doc = new Document();
        doc.append("idannonce", Annonce.getIdannonce());
        doc.append("descri", Annonce.getDescri());
        doc.append("prix", Annonce.getPrix());
        doc.append("datepub", Annonce.getDatepub());
        doc.append("idvoiture", Annonce.getIdvoiture());
        doc.append("idutilisateur", Annonce.getIdutilisateur());
      
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().upsert(true).returnDocument(ReturnDocument.AFTER);
        Document result = AnnonceCollection.findOneAndReplace(Filters.eq("idannonce", Annonce.getIdannonce()), doc, options);
        
        String dateStr = result.getString("datepub");
        LocalDateTime datePub = convertStringToLocalDateTime(dateStr);
      
        return new Annonce(result.getInteger("idannonce"), result.getString("descri"), result.getDouble("prix"), datePub, result.getInteger("idvoiture"), result.getInteger("idutilisateur"));
    }      

    public Document findById(int idAnnonce) {
        return AnnonceCollection.find(new Document("idannonce", idAnnonce)).first();
    }

    public void updateAnnonce(int idAnnonce, Document updatedAnnonce) {
        AnnonceCollection.updateOne(new Document("idannonce", idAnnonce), new Document("$set", updatedAnnonce));
    }

    public void deleteAnnonce(int idAnnonce) {
        AnnonceCollection.deleteOne(new Document("idannonce", idAnnonce));
    }
}

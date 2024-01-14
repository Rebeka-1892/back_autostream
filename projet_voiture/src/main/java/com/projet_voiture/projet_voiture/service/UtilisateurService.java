package com.projet_voiture.projet_voiture.service;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.projet_voiture.projet_voiture.modele.Utilisateur;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private final MongoCollection<Document> UtilisateurCollection;

    public UtilisateurService(MongoClient mongoClient, @Value("${databaseName}") String databaseName,
            @Value("${utilisateur}") String collectionName) {
        this.UtilisateurCollection = mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public FindIterable<Document> findAll() {
        return UtilisateurCollection.find();
    }

    public Utilisateur insert(Utilisateur Utilisateur) {
        Document doc = new Document();
        doc.append("idutilisateur", Utilisateur.getIdutilisateur());
        doc.append("nomutilisateur", Utilisateur.getNomutilisateur());
        doc.append("email", Utilisateur.getEmail());
        doc.append("mdp", Utilisateur.getMdp());
        doc.append("isadmin", Utilisateur.getIsadmin());
      
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().upsert(true).returnDocument(ReturnDocument.AFTER);
        Document result = UtilisateurCollection.findOneAndReplace(Filters.eq("idutilisateur", Utilisateur.getIdutilisateur()), doc, options);
      
        return new Utilisateur(result.getString("idutilisateur"), result.getString("nomutilisateur"), result.getString("email"), result.getString("mdp"), result.getInteger("isadmin"));
    }      

    public Document findById(String idUtilisateur) {
        return UtilisateurCollection.find(new Document("idutilisateur", idUtilisateur)).first();
    }

    public void updateUtilisateur(String idUtilisateur, Document updatedUtilisateur) {
        UtilisateurCollection.updateOne(new Document("idutilisateur", idUtilisateur), new Document("$set", updatedUtilisateur));
    }

    public void deleteUtilisateur(String idUtilisateur) {
        UtilisateurCollection.deleteOne(new Document("idutilisateur", idUtilisateur));
    }
}

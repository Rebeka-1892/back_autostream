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
import com.projet_voiture.projet_voiture.modele.Validation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final MongoCollection<Document> ValidationCollection;

    public LocalDateTime convertStringToLocalDateTime(String dateStr) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return LocalDateTime.parse(dateStr, formatter);
   }

    public ValidationService(MongoClient mongoClient, @Value("${databaseName}") String databaseName,
            @Value("${validation}") String collectionName) {
        this.ValidationCollection = mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public FindIterable<Document> findAll() {
        return ValidationCollection.find();
    }

    public Validation insert(Validation Validation) {
        Document doc = new Document();
        doc.append("idvalidation", Validation.getIdvalidation());
        doc.append("etat", Validation.getEtat());
        doc.append("datemodif", Validation.getDatemodif());
        doc.append("idannonce", Validation.getIdannonce());
      
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().upsert(true).returnDocument(ReturnDocument.AFTER);
        Document result = ValidationCollection.findOneAndReplace(Filters.eq("idValidation", Validation.getIdvalidation()), doc, options);
      
        String dateStr = result.getString("datemodif");
        LocalDateTime datemodif = convertStringToLocalDateTime(dateStr);

        return new Validation(result.getInteger("idvalidation"), result.getInteger("etat"), datemodif, result.getInteger("idannonce"));
    }
      

    public Document findById(int idValidation) {
        return ValidationCollection.find(new Document("idvalidation", idValidation)).first();
    }

    public void updateValidation(int idValidation, Document updatedValidation) {
        ValidationCollection.updateOne(new Document("idvalidation", idValidation), new Document("$set", updatedValidation));
    }

    public void deleteValidation(int idValidation) {
        ValidationCollection.deleteOne(new Document("idvalidation", idValidation));
    }
}

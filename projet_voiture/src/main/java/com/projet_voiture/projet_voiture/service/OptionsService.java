package com.projet_voiture.projet_voiture.service;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.projet_voiture.projet_voiture.modele.Options;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OptionsService {
    private final MongoCollection<Document> OptionsCollection;

    public OptionsService(MongoClient mongoClient, @Value("${databaseName}") String databaseName,
            @Value("${options}") String collectionName) {
        this.OptionsCollection = mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public FindIterable<Document> findAll() {
        return OptionsCollection.find();
    }

    public Options insert(Options Options) {
        Document doc = new Document();
        doc.append("idoptions", Options.getIdoptions());
        doc.append("nomoptions", Options.getNomoptions());
        doc.append("idtype", Options.getIdtype());
      
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().upsert(true).returnDocument(ReturnDocument.AFTER);
        Document result = OptionsCollection.findOneAndReplace(Filters.eq("idoptions", Options.getIdoptions()), doc, options);
      
        return new Options(result.getInteger("idoptions"), result.getString("nomoptions"), result.getInteger("idtype"));
    }
      

    public Document findById(int idOptions) {
        return OptionsCollection.find(new Document("idoptions", idOptions)).first();
    }

    public void updateOptions(int idOptions, Document updatedOptions) {
        OptionsCollection.updateOne(new Document("idoptions", idOptions), new Document("$set", updatedOptions));
    }

    public void deleteOptions(int idOptions) {
        OptionsCollection.deleteOne(new Document("idoptions", idOptions));
    }
}

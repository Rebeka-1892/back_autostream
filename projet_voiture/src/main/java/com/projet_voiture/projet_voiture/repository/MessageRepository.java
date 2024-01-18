package com.projet_voiture.projet_voiture.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.projet_voiture.projet_voiture.modele.Message;
// import org.springframework.data.mongodb.repository.Query;

public interface MessageRepository extends MongoRepository<Message, String>{
    // message par les utilsateurs where idsender et idreceiver group by idsender et receiver
}
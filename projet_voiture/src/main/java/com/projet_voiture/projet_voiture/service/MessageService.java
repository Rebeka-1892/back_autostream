package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Message;
import com.projet_voiture.projet_voiture.repository.MessageRepository;

import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public Message insert(Message Message) {
        Message.setIdmessage(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Message);
    }

    public List<Message> findAll() {
        return repository.findAll();
    }

    public Message findById(String MessageId){
        return repository.findById(MessageId).get();
    }

    public String deleteMessage(String MessageId){
        repository.deleteById(MessageId);
        return MessageId+" Message deleted from dashboard ";
    }
}

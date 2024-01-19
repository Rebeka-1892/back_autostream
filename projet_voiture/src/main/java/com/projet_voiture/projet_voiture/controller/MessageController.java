package com.projet_voiture.projet_voiture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import com.projet_voiture.projet_voiture.modele.Message;
import com.projet_voiture.projet_voiture.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService service;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Message insert(@RequestBody Message Message) {
        return service.insert(Message);
    }

    @GetMapping
    public List<Message> findAll() {
        return service.findAll();
    }

    @GetMapping("/{MessageId}")
    public Message findById(@PathVariable String MessageId) {
        return service.findById(MessageId);
    }

    @DeleteMapping("/{MessageId}")
    public String deleteMessage(@PathVariable String MessageId) {
        return service.deleteMessage(MessageId);
    }
}
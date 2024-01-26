package com.projet_voiture.projet_voiture.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;

import com.projet_voiture.projet_voiture.modele.Message;
import com.projet_voiture.projet_voiture.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService service;

     
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public Message insert(@RequestBody Message message) {

        if(message.getDateheure() == null) {
            message.setDateheure(LocalDateTime.now());
        }

        return service.insert(message);
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

    @GetMapping("/messages")
    public Set<Message> getMessagesBetweenUsers(
            @RequestParam String idSend,
            @RequestParam String idReceive) {
        return service.findByIdSendAndIdReceive(idSend, idReceive);
    }
}

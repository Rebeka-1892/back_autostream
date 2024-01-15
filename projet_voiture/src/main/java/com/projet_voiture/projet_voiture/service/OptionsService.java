package com.projet_voiture.projet_voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet_voiture.projet_voiture.modele.Options;
import com.projet_voiture.projet_voiture.repository.OptionsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class OptionsService {
    @Autowired
    private OptionsRepository repository;

    public Options insert(Options Options) {
        Options.setIdoptions(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Options);
    }

    public List<Options> findAll() {
        return repository.findAll();
    }

    public Options findById(String OptionsId){
        return repository.findById(OptionsId).get();
    }

    public Options updateOptions(Options OptionsRequest){
        Options existingOptions = repository.findById(OptionsRequest.getIdoptions()).get();
        existingOptions.setNomoptions(OptionsRequest.getNomoptions());
        existingOptions.setIdtype(OptionsRequest.getIdtype());
        return repository.save(existingOptions);
    }

    public String deleteOptions(String OptionsId){
        repository.deleteById(OptionsId);
        return OptionsId+" Options deleted from dashboard ";
    }
}

package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.InterfaceClient;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final InterfaceClient service;

    @GetMapping("/getAll")
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Client getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client entity) {
        Client existing = service.getById(id);
        if (entity.getNom() != null) existing.setNom(entity.getNom());
        if (entity.getPrenom() != null) existing.setPrenom(entity.getPrenom());
        if (entity.getEmail() != null) existing.setEmail(entity.getEmail());
        if (entity.getTelephone() != null) existing.setTelephone(entity.getTelephone());
        if (entity.getNumPermis() != null) existing.setNumPermis(entity.getNumPermis());
        if (entity.getDateInscription() != null) existing.setDateInscription(entity.getDateInscription());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.InterfaceAgence;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final InterfaceAgence service;

    @GetMapping("/getAll")
    public List<Agence> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Agence getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Agence save(@RequestBody Agence entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Agence update(@PathVariable Long id, @RequestBody Agence entity) {
        Agence existing = service.getById(id);
        if (entity.getNom() != null) existing.setNom(entity.getNom());
        if (entity.getVille() != null) existing.setVille(entity.getVille());
        if (entity.getAdresse() != null) existing.setAdresse(entity.getAdresse());
        if (entity.getTelephone() != null) existing.setTelephone(entity.getTelephone());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

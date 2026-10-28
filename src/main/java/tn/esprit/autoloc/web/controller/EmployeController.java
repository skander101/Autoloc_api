package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.InterfaceEmploye;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final InterfaceEmploye service;

    @GetMapping("/getAll")
    public List<Employe> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Employe getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Employe save(@RequestBody Employe entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Employe update(@PathVariable Long id, @RequestBody Employe entity) {
        Employe existing = service.getById(id);
        if (entity.getNom() != null) existing.setNom(entity.getNom());
        if (entity.getPrenom() != null) existing.setPrenom(entity.getPrenom());
        if (entity.getRole() != null) existing.setRole(entity.getRole());
        if (entity.getAgence() != null) existing.setAgence(entity.getAgence());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

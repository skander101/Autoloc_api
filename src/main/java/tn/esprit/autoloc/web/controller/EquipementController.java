package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.InterfaceEquipement;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final InterfaceEquipement service;

    @GetMapping("/getAll")
    public List<Equipement> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Equipement getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Equipement save(@RequestBody Equipement entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Equipement update(@PathVariable Long id, @RequestBody Equipement entity) {
        Equipement existing = service.getById(id);
        if (entity.getLibelle() != null) existing.setLibelle(entity.getLibelle());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

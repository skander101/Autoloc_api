package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.InterfaceVehicule;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final InterfaceVehicule service;

    @GetMapping("/getAll")
    public List<Vehicule> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Vehicule getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Vehicule save(@RequestBody Vehicule entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Vehicule update(@PathVariable Long id, @RequestBody Vehicule entity) {
        Vehicule existing = service.getById(id);
        if (entity.getImmatriculation() != null) existing.setImmatriculation(entity.getImmatriculation());
        if (entity.getMarque() != null) existing.setMarque(entity.getMarque());
        if (entity.getModele() != null) existing.setModele(entity.getModele());
        if (entity.getCategorie() != null) existing.setCategorie(entity.getCategorie());
        if (entity.getTarifJournalier() != null) existing.setTarifJournalier(entity.getTarifJournalier());
        if (entity.getStatut() != null) existing.setStatut(entity.getStatut());
        if (entity.getAgence() != null) existing.setAgence(entity.getAgence());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

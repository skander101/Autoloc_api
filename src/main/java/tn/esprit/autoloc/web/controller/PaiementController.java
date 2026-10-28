package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.InterfacePaiement;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final InterfacePaiement service;

    @GetMapping("/getAll")
    public List<Paiement> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Paiement getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Paiement save(@RequestBody Paiement entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Paiement update(@PathVariable Long id, @RequestBody Paiement entity) {
        Paiement existing = service.getById(id);
        if (entity.getMontant() != null) existing.setMontant(entity.getMontant());
        if (entity.getDatePaiement() != null) existing.setDatePaiement(entity.getDatePaiement());
        if (entity.getModePaiement() != null) existing.setModePaiement(entity.getModePaiement());
        if (entity.getContrat() != null) existing.setContrat(entity.getContrat());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

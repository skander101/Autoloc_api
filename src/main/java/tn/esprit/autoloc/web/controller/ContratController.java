package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.InterfaceContrat;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final InterfaceContrat service;

    @GetMapping("/getAll")
    public List<Contrat> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Contrat getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Contrat save(@RequestBody Contrat entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Contrat update(@PathVariable Long id, @RequestBody Contrat entity) {
        Contrat existing = service.getById(id);
        if (entity.getDateSignature() != null) existing.setDateSignature(entity.getDateSignature());
        if (entity.getMontantTotal() != null) existing.setMontantTotal(entity.getMontantTotal());
        if (entity.getValide() != null) existing.setValide(entity.getValide());
        if (entity.getReservation() != null) existing.setReservation(entity.getReservation());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

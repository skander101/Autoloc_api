package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.InterfaceMaintenance;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {

    private final InterfaceMaintenance service;

    @GetMapping("/getAll")
    public List<Maintenance> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Maintenance getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Maintenance save(@RequestBody Maintenance entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Maintenance update(@PathVariable Long id, @RequestBody Maintenance entity) {
        Maintenance existing = service.getById(id);
        if (entity.getDateDebut() != null) existing.setDateDebut(entity.getDateDebut());
        if (entity.getDateFin() != null) existing.setDateFin(entity.getDateFin());
        if (entity.getDescription() != null) existing.setDescription(entity.getDescription());
        if (entity.getVehicule() != null) existing.setVehicule(entity.getVehicule());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

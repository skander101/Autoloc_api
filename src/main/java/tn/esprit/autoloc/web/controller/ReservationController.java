package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.InterfaceReservation;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final InterfaceReservation service;

    @GetMapping("/getAll")
    public List<Reservation> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public Reservation getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation entity) {
        return service.save(entity);
    }

    @PatchMapping("/update/{id}")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation entity) {
        Reservation existing = service.getById(id);
        if (entity.getDateDebut() != null) existing.setDateDebut(entity.getDateDebut());
        if (entity.getDateFin() != null) existing.setDateFin(entity.getDateFin());
        if (entity.getStatut() != null) existing.setStatut(entity.getStatut());
        if (entity.getVehicule() != null) existing.setVehicule(entity.getVehicule());
        if (entity.getClient() != null) existing.setClient(entity.getClient());
        return service.save(existing);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

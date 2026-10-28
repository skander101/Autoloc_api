package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface InterfaceReservation {

    List<Reservation> getAll();

    Reservation getById(Long id);

    Reservation save(Reservation entity);

    void deleteById(Long id);
}

package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface InterfaceVehicule {

    List<Vehicule> getAll();

    Vehicule getById(Long id);

    Vehicule save(Vehicule entity);

    void deleteById(Long id);
}

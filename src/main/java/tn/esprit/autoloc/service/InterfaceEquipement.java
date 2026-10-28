package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface InterfaceEquipement {

    List<Equipement> getAll();

    Equipement getById(Long id);

    Equipement save(Equipement entity);

    void deleteById(Long id);
}

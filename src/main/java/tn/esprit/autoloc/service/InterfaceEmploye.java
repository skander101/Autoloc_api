package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface InterfaceEmploye {

    List<Employe> getAll();

    Employe getById(Long id);

    Employe save(Employe entity);

    void deleteById(Long id);
}

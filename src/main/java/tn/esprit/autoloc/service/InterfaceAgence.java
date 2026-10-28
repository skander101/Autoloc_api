package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface InterfaceAgence {

    List<Agence> getAll();

    Agence getById(Long id);

    Agence save(Agence entity);

    void deleteById(Long id);
}

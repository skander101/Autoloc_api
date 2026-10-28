package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface InterfaceContrat {

    List<Contrat> getAll();

    Contrat getById(Long id);

    Contrat save(Contrat entity);

    void deleteById(Long id);
}

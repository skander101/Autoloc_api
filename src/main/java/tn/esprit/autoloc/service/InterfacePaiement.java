package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface InterfacePaiement {

    List<Paiement> getAll();

    Paiement getById(Long id);

    Paiement save(Paiement entity);

    void deleteById(Long id);
}

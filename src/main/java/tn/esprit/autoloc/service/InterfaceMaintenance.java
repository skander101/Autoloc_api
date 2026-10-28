package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface InterfaceMaintenance {

    List<Maintenance> getAll();

    Maintenance getById(Long id);

    Maintenance save(Maintenance entity);

    void deleteById(Long id);
}

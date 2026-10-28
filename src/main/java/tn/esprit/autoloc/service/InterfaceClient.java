package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface InterfaceClient {

    List<Client> getAll();

    Client getById(Long id);

    Client save(Client entity);

    void deleteById(Long id);
}

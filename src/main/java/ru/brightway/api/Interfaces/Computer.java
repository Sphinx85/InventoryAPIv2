package ru.brightway.api.Interfaces;

import ru.brightway.api.Entites.DomainComputer;
import ru.brightway.api.Entites.DomainUser;

import java.util.List;

public interface Computer {
    List<DomainComputer> findTerritory(String city);

    List<DomainComputer> findAll();

    List<DomainComputer> findByDomain(String domainName);

    List<DomainUser> getUsersFromTerritory(List<DomainComputer> computers);
}

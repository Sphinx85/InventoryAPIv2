package ru.brightway.api.Interfaces;

import ru.brightway.api.Entites.DomainGroup;

import java.util.List;

public interface Group {
    List<DomainGroup> getAll();

    List<DomainGroup> findByDomain(String domainName);
}

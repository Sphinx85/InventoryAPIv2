package ru.brightway.api.Interfaces;

import ru.brightway.api.Entites.DomainUser;

import java.util.List;

public interface User  {
    List<DomainUser> findAll();

    List<DomainUser> findByDomain(String domainName);

    List<DomainUser> findDisable(boolean state);

    List<DomainUser> findByName(String name);

    List<DomainUser> findByPhone(String name);

    List<DomainUser> findBySamAccountName(String name);

    List<DomainUser> findActive(boolean old);
}

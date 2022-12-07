package ru.brightway.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.brightway.api.Entites.DomainUser;

import java.util.List;

public interface UserRepository extends JpaRepository<DomainUser, Integer> {

    List<DomainUser> findByLastName(String lastname);

    List<DomainUser> findByDomain(String domainName);


    List<DomainUser> accountIsEnabled(boolean state);

    List<DomainUser> findByName(String name);


    List<DomainUser> findByFirstName(String name);
}

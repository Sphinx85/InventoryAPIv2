package ru.brightway.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.brightway.api.Entites.DomainUser;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<DomainUser, Integer> {

    List<DomainUser> findByDomain(String domainName);

    List<DomainUser> accountIsEnabled(boolean state);

    List<DomainUser> findByNameContaining(String name);

    List<DomainUser> findByTelephoneContainingAndAccountIsEnabled(String name, boolean b);

    List<DomainUser> findBySamAccountNameContainingAndAccountIsEnabled(String name, boolean b);

    List<DomainUser> findByLastLogonTimestampBefore(LocalDate date);

    List<DomainUser> findByLastLogonTimestampAfter(LocalDate date);
}

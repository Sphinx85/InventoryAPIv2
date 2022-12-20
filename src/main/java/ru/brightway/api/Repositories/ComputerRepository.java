package ru.brightway.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.brightway.api.Entites.DomainComputer;

import java.util.List;

public interface ComputerRepository extends JpaRepository <DomainComputer, String> {
    List<DomainComputer> findByDomain(String domainName);

    List<DomainComputer> findByIpContaining(String s);

    List<DomainComputer> findByIpContainingOrIpContaining(String s, String s1);

    List<DomainComputer> findByNameContaining(String name);
}

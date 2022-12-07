package ru.brightway.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.brightway.api.Entites.DomainComputer;

import java.util.List;

public interface ComputerRepository extends JpaRepository <DomainComputer, String> {
    List<DomainComputer> findByDomain(String domainName);
}

package ru.brightway.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.brightway.api.Entites.DomainGroup;

import java.util.List;

public interface GroupRepository extends JpaRepository<DomainGroup, String> {
    List<DomainGroup> findByDomain(String domainName);
}

package ru.brightway.api.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.brightway.api.Entites.DomainGroup;
import ru.brightway.api.Interfaces.Group;
import ru.brightway.api.Repositories.GroupRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class GroupService implements Group {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<DomainGroup> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public List<DomainGroup> findByDomain(String domainName) {
        return groupRepository.findByDomain(domainName);
    }
}

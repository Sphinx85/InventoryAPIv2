package ru.brightway.api.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.brightway.api.Entites.DomainComputer;
import ru.brightway.api.Entites.DomainUser;
import ru.brightway.api.Interfaces.Computer;
import ru.brightway.api.Repositories.ComputerRepository;
import ru.brightway.api.Repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
public class ComputerService implements Computer {

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<DomainComputer> findTerritory(String territory) {
        switch (territory) {
            case "city" -> {
                return computerRepository.findByIpContaining("10.100");
            }
            case "apr" -> {
                return computerRepository.findByIpContaining("192.168");
            }
            case "zel" ->{
                return computerRepository.findByIpContainingOrIpContaining("10.102","10.103");
            }
            case "dolg" -> {
                return computerRepository.findByIpContaining("10.105");
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public List<DomainUser> getUsersFromTerritory(List<DomainComputer> computers){
        return userRepository.findAll()
                .stream()
                .filter(user -> computers
                        .stream()
                        .anyMatch(computer -> computer.getManagedBy().contains(user.getName())))
                .filter(DomainUser::getAccountIsEnabled)
                .collect(Collectors.toList());
    }

    @Override
    public List<DomainComputer> findByName(String name) {
        return computerRepository.findByNameContaining(name);
    }

    @Override
    public List<DomainComputer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public List<DomainComputer> findByDomain(String domainName) {
        return computerRepository.findByDomain(domainName);
    }

}

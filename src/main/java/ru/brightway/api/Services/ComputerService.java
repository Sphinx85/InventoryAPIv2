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
        List<DomainComputer> computers = computerRepository.findAll();

        computers.removeIf(comp -> comp.getIp().equals(""));

        switch (territory) {
            case "city" -> computers.removeIf(comp -> !comp.getIp().contains("10.100"));
            case "apr" -> computers.removeIf(comp -> !comp.getIp().contains("192.168"));
            case "zel" -> computers.removeIf(comp -> !comp.getIp().contains("10.102") && !comp.getIp().contains("10.103"));
            case "dolg" -> computers.removeIf(comp -> !comp.getIp().contains("10.105"));
        }

       return computers;
    }

    @Override
    public List<DomainUser> getUsersFromTerritory(List<DomainComputer> computers){
        List<DomainUser> users = userRepository.findAll();
        users.removeIf(user -> computers.stream().noneMatch(computer -> computer.getManagedBy().contains(user.getName())));
        return removeDeleted(users);
    }

    @Override
    public List<DomainComputer> findByName(String name) {
        List<DomainComputer> computers = computerRepository.findAll();
        computers.removeIf(computer -> !computer.getName().contains(name));
        return computers;
    }

    @Override
    public List<DomainComputer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public List<DomainComputer> findByDomain(String domainName) {
        return computerRepository.findByDomain(domainName);
    }

    private List<DomainUser> removeDeleted (List<DomainUser> users){
        users.removeIf(user -> !user.getAccountIsEnabled());
        System.out.println("users without inactive " + users.size());
        return users;
    }
}

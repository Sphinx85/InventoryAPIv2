package ru.brightway.api.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.brightway.api.Entites.DomainComputer;
import ru.brightway.api.Entites.DomainUser;
import ru.brightway.api.Interfaces.User;
import ru.brightway.api.Repositories.ComputerRepository;
import ru.brightway.api.Repositories.UserRepository;

import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
@Data
public class UserService implements User {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public List<DomainUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<DomainUser> findByLastName(String lastname) {
        return userRepository.findByLastName(lastname);
    }

    @Override
    public List<DomainUser> findByDomain(String domainName) {
        return userRepository.findByDomain(domainName);
    }

    @Override
    public List<DomainUser> findDisable(boolean state) {
        return userRepository.accountIsEnabled(state);
    }

    @Override
    public List<DomainUser> findByName(String name) {
        List<DomainUser> users = userRepository.findAll();
        List<DomainComputer> computers = computerRepository.findAll();
        if (name.contains("1") || name.contains("0")){
            computers.removeIf(computer -> !computer.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)));
        }
        users.removeIf(user -> !user.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)));
        if (users.size() == 0) users = userRepository.findAll();
        if (name.contains("1") || name.contains("0")) {
            users.removeIf(user -> computers.stream().noneMatch(computer -> computer.getManagedBy().contains(user.getName())));
        }

        return users;
    }
}

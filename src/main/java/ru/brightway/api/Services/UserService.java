package ru.brightway.api.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        users.removeIf(user -> !user.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)));
        return removeOld(users);
    }

    private List<DomainUser> removeOld(List<DomainUser> users) {
        users.removeIf(user -> !user.getAccountIsEnabled());
        return users;
    }

    @Override
    public List<DomainUser> findByPhone(String name) {
        List<DomainUser> users = userRepository.findAll();
        users.removeIf(user -> !user.getTelephone().contains(name));
        return removeOld(users);
    }

    @Override
    public List<DomainUser> findBySamAccountName(String name) {
        List<DomainUser> users = userRepository.findAll();
        users.removeIf(user -> !user.getSamAccountName().contains(name));
        return removeOld(users);
    }


}

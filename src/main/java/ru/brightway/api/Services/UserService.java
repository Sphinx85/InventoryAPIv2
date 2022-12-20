package ru.brightway.api.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.brightway.api.Entites.DomainUser;
import ru.brightway.api.Interfaces.User;
import ru.brightway.api.Repositories.ComputerRepository;
import ru.brightway.api.Repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Data
public class UserService implements User {

    static LocalDate date = LocalDate.now().minusMonths(1);

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
        return userRepository.findByNameContaining(name);
    }

    @Override
    public List<DomainUser> findByPhone(String name) {
        return userRepository.findByTelephoneContainingAndAccountIsEnabled(name, true);
    }

    @Override
    public List<DomainUser> findBySamAccountName(String name) {
        return userRepository.findBySamAccountNameContainingAndAccountIsEnabled(name,true);
    }

    @Override
    public List<DomainUser> findActive(boolean old) {
        return old ?
                userRepository.findByLastLogonTimestampAfter(date):
                userRepository.findByLastLogonTimestampBefore(date);
    }
}

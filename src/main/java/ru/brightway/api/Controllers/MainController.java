package ru.brightway.api.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.brightway.api.Entites.DomainComputer;
import ru.brightway.api.Entites.DomainUser;
import ru.brightway.api.Interfaces.Computer;
import ru.brightway.api.Interfaces.Group;
import ru.brightway.api.Interfaces.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class MainController {

    @Autowired
    private Group group;

    @Autowired
    private User user;

    @Autowired
    private Computer computer;

    @GetMapping("/all")
    List<DomainUser> getUsers(){
        return user.findAll();
    }

    @GetMapping("/{name}")
    List<?> getUserForChar(@PathVariable(name = "name") String name){
        List<Object> response = new ArrayList<>(10);
        List<DomainUser> users = user.findByName(name);
        List<DomainComputer> computers = computer.findByName(name);

        if (users.isEmpty()) users = user.findByPhone(name);
        if (!users.isEmpty() || computers.isEmpty()){
            List<DomainComputer> computerList = computer.findAll();
            List<DomainUser> finalUsers = users;
            computerList.removeIf(computer -> finalUsers.stream().noneMatch(user -> computer.getManagedBy().contains(user.getName())));
            computers.addAll(computerList);
        }
        if (users.isEmpty()) {
            users = user.findAll();
            users.removeIf(user -> computers.stream().noneMatch(computer -> computer.getManagedBy().contains(user.getName())));
        }
        response.add(users);
        response.add(computers);
        return response;
    }

    @GetMapping("/error")
    String error(){
        return "error";
    }
}

package ru.brightway.api.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.brightway.api.Entites.DomainUser;
import ru.brightway.api.Interfaces.Computer;
import ru.brightway.api.Interfaces.Group;
import ru.brightway.api.Services.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private Computer computer;

    @Autowired
    private Group group;

    @GetMapping("/all")
    List<DomainUser> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/{name}")
    List<DomainUser> getUserByLastName(@PathVariable(name = "name") String name){
        return userService.findByName(name);
    }

    @GetMapping("/error")
    String error(){
        return "error";
    }
}

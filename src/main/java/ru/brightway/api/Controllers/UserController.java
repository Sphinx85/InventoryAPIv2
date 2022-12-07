package ru.brightway.api.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.brightway.api.Entites.DomainUser;
import ru.brightway.api.Services.ComputerService;
import ru.brightway.api.Services.UserService;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ComputerService computerService;

    /**
     * Get all users
     * @return Returns an array of users
     */
    @GetMapping("/all")
    List<DomainUser> getAllUsers(){
        return userService.findAll();
    }

    /**
     * Get indukern.local users
     * @return Returns an array of indukern domain users
     */
    @GetMapping("/indukern")
    List<DomainUser> getIndukern(){
        return userService.findByDomain("indukern.local");
    }
    /**
     * Get velpharm.local users
     * @return Returns an array of velpharm domain users
     */
    @GetMapping("/velpharm")
    List<DomainUser> getVelpharm(){
        return userService.findByDomain("velpharm.local");
    }
    /**
     * Get active users
     * @return Returns an array of active users
     */
    @GetMapping("active")
    List<DomainUser> getActivity(){
        return activityList(true);
    }
    /**
     * Get inactive users
     * @return Returns an array of inactive users
     */
    @GetMapping("inactive")
    List<DomainUser> getNonActivity(){
        return activityList(false);
    }
    /**
     * Get disabled users
     * @return Returns an array of disabled users
     */
    @GetMapping("disabled")
    List<DomainUser> getDisabled(){
        return userService.findDisable(false);
    }

    /**
     * Get City users
     * @return Returns an array of users of the City territory
     */
    @GetMapping("city")
    List<DomainUser> getCity(){
        return computerService.getUsersFromTerritory(computerService.findTerritory("city"));
    }
    /**
     * Get Aprelevka users
     * @return Returns an array of users of the Aprelevka territory
     */
    @GetMapping("apr")
    List<DomainUser> getApr(){
        return computerService.getUsersFromTerritory(computerService.findTerritory("apr"));
    }
    /**
     * Get Zelenograd users
     * @return Returns an array of users of the Zelenograd territory
     */
    @GetMapping("zel")
    List<DomainUser> getZel(){
        return computerService.getUsersFromTerritory(computerService.findTerritory("zel"));
    }

    @GetMapping("test")
    Duration getTest(){
        List<DomainUser> user = userService.findByLastName("Гузева");

        return null;
    }

    private List<DomainUser> activityList(boolean old){
        List<DomainUser> users = userService.findAll();
        users.removeIf(old ?
                (user -> 2592000 < Instant.now().getEpochSecond() - user.getLastLogonTimestamp().getEpochSecond()) :
                (user -> 2592000 > Instant.now().getEpochSecond() - user.getLastLogonTimestamp().getEpochSecond()));
        return users;
    }
}

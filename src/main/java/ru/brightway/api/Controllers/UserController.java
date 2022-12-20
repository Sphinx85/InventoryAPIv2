package ru.brightway.api.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.brightway.api.Entites.DomainUser;
import ru.brightway.api.Interfaces.Computer;
import ru.brightway.api.Interfaces.User;

import java.util.List;

/**
 * Controller domain users
 */
@RestController
@Data
@AllArgsConstructor
@RequestMapping("/users")

public class UserController {
    /**
     * Include service
     */
    @Autowired
    private User user;
    /**
     * Include service
     */
    @Autowired
    private Computer computer;
    /**
     * Get all users
     * @return Returns an array of users
     */
    @GetMapping("/all")
    List<DomainUser> getAllUsers(){
        return user.findAll();
    }
    /**
     * Get indukern.local users
     * @return Returns an array of indukern domain users
     */
    @GetMapping("/indukern")
    List<DomainUser> getIndukern(){
        return user.findByDomain("indukern.local");
    }
    /**
     * Get velpharm.local users
     * @return Returns an array of velpharm domain users
     */
    @GetMapping("/velpharm")
    List<DomainUser> getVelpharm(){
        return user.findByDomain("velpharm.local");
    }
    /**
     * Get active users
     * @return Returns an array of active users
     */
    @GetMapping("active")
    List<DomainUser> getActivity(){
        return user.findActive(true);
    }
    /**
     * Get inactive users
     * @return Returns an array of inactive users
     */
    @GetMapping("inactive")
    List<DomainUser> getNonActivity(){
        return user.findActive(false);
    }
    /**
     * Get disabled users
     * @return Returns an array of disabled users
     */
    @GetMapping("disabled")
    List<DomainUser> getDisabled(){
        return user.findDisable(false);
    }
    /**
     * Get City users
     * @return Returns an array of users of the City territory
     */
    @GetMapping("city")
    List<DomainUser> getCity(){
        return computer.getUsersFromTerritory(computer.findTerritory("city"));
    }
    /**
     * Get Aprelevka users
     * @return Returns an array of users of the Aprelevka territory
     */
    @GetMapping("apr")
    List<DomainUser> getApr(){
        return computer.getUsersFromTerritory(computer.findTerritory("apr"));
    }
    /**
     * Get Zelenograd users
     * @return Returns an array of users of the Zelenograd territory
     */
    @GetMapping("zel")
    List<DomainUser> getZel(){
        return computer.getUsersFromTerritory(computer.findTerritory("zel"));
    }

}

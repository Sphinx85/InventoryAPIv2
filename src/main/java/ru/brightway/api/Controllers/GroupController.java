package ru.brightway.api.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.brightway.api.Entites.DomainGroup;
import ru.brightway.api.Interfaces.Group;

import java.util.List;
/**
 * Controller domain groups
 */
@RestController
@Data
@AllArgsConstructor
@RequestMapping("/group")

public class GroupController {
    /**
     * Include service
     */
    @Autowired
    private Group group;

    /**
     * Get all domain groups
     * @return Returns an array of all domain groups
     */
    @GetMapping("all")
    List<DomainGroup> getAllGroups(){
        return group.getAll();
    }
    /**
     * Get indukern.local domain groups
     * @return Returns an array of all groups of the indukern domain
     */
    @GetMapping("/indukern")
    List<DomainGroup> getIndukern(){
        return group.findByDomain("indukern.local");
    }
    /**
     * Get velpharm.local domain groups
     * @return Returns an array of all groups of the velpharm domain
     */
    @GetMapping("/velpharm")
    List<DomainGroup> getVelpharm(){
        return group.findByDomain("velpharm.local");
    }
}

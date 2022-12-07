package ru.brightway.api.Controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.brightway.api.Entites.DomainComputer;
import ru.brightway.api.Services.ComputerService;
import java.util.List;

@RestController
@AllArgsConstructor
@Data
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    /**
     * Get all computers.
     * @return JSON array of computers
     */
    @GetMapping ("/all")
    List<DomainComputer> getAllComputers(){
        return computerService.findAll();
    }

    /**
     * Get indukern.local domain computers
     * @return JSON array of computers of the indukern domain
     */
    @GetMapping("/indukern")
    List<DomainComputer> getIndukern(){
        return computerService.findByDomain("indukern.local");
    }

    /**
     * Get indukern.local domain computers
     * @return JSON array of computers of the velpharm domain
     */
    @GetMapping("/velpharm")
    List<DomainComputer> getVelpharm(){
        return computerService.findByDomain("velpharm.local");
    }
    /**
     * Get City territory computers
     * @return JSON array of computers of the city territory
     */
    @GetMapping("city")
    List<DomainComputer> getCity(){
        return computerService.findTerritory("city");
    }
    /**
     * Get Aprelevka territory computers
     * @return JSON array of computers of the Aprelevka territory
     */
    @GetMapping("apr")
    List<DomainComputer> getApr(){
        return computerService.findTerritory("apr");
    }
    /**
     * Get Zelenograd territory computers
     * @return JSON array of computers of the Zelenograd territory
     */
    @GetMapping("zel")
    List<DomainComputer> getZel(){
        return computerService.findTerritory("zel");
    }
    /**
     * Get Dolgoprudniy territory computers
     * @return JSON array of computers of the Dolgoprudniy territory
     */
    @GetMapping("dolg")
    List<DomainComputer> getDolg(){
        return computerService.findTerritory("dolg");
    }
}

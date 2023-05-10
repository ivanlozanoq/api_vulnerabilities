/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.wom.vulnerabilidades;

import co.wom.vulnerabilidades.entities.Summary;
import co.wom.vulnerabilidades.entities.Vulnerabilities;
import co.wom.vulnerabilidades.services.VulnerabilitiesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VulnerabilidadController {

    @Autowired
    private VulnerabilitiesService s;

    @GetMapping("/ping")
    public String ejemplo() {
        return "pong";
    }

    @PostMapping("/vulnerabilities/update")
    public void updateVulnerabilities() {
        s.GetCves();
    }

    @GetMapping("/vulnerabilities")
    public List<Vulnerabilities> listar() {
        return s.listar();
    }

    @GetMapping("/vulnerabilities/summary")
    public List<Summary> getSummay() {
        return s.getSummary();
    }

    @PostMapping("/vulnerabilities/{id}/fix")
    public String setAsFixed(@PathVariable String id) {
        return s.setAsFixed(id);
    }
    
    @GetMapping("/vulnerabilities/unfixed")
    public List<Vulnerabilities> getNotFixed(){
         return s.getNotFixed();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.wom.vulnerabilidades.entities;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Cve {
    
    private String id;

    private String sourceIdentifier;

    private Date published;

    private Date lastModified;

    private String vulnStatus;

    private List<Description> descriptions;

    private Metric metrics;

    private List<Weaknesses> weaknesses;

    private List<Configurations> configurations;

    private List<References> references;
}

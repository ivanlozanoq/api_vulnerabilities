/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.wom.vulnerabilidades.entities;

import lombok.Data;

@Data
public class CVSSMetricV2 {
    private String source;
    private String type;
    private String baseSeverity;
    private double exploitabilityScore;
    private double impactScore;
    private boolean acInsufInfo;
    private boolean obtainAllPrivilege;
    private boolean obtainUserPrivilege;
    private boolean obtainOtherPrivilege;
    private boolean userInteractionRequired;
    private CVSSData cvssData;
}

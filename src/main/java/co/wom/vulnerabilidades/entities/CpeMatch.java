/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.wom.vulnerabilidades.entities;

import lombok.Data;

@Data
public class CpeMatch {
    private boolean vulnerable;
    private String criteria;
    private String matchCriteriaId;

}

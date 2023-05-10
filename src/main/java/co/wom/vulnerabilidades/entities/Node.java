/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.wom.vulnerabilidades.entities;

import java.util.List;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
public class Node {

    private String operator;
    private boolean negate;
    private List<CpeMatch> cpeMatch;

}

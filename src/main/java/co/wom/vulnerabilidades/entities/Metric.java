package co.wom.vulnerabilidades.entities;

import java.util.ArrayList;
import lombok.Data;

@Data
public class Metric {  

    private ArrayList<CVSSMetricV2> cvssMetricV2;
}

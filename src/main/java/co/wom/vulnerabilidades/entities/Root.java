package co.wom.vulnerabilidades.entities;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class Root {

    public int resultsPerPage;
    public int startIndex;
    public int totalResults;
    public String format;
    public String version;
    public Date timestamp;
    public ArrayList<Vulnerability> vulnerabilities;

    
    

//    ArrayList<Vulnerabilities> vulnerabilities = new ArrayList<Vulnerabilities>();
//    @OneToOne(mappedBy = "principal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Vulnerabilities vulnerabilities;

//@OneToMany(mappedBy = "principal")
//private Vulnerabilities vulnerabilities;    
}

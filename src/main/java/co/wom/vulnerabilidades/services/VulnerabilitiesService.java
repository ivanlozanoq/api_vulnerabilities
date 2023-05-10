/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.wom.vulnerabilidades.services;

import co.wom.vulnerabilidades.entities.Fixed;
import co.wom.vulnerabilidades.entities.Root;
import co.wom.vulnerabilidades.entities.Summary;
import co.wom.vulnerabilidades.entities.SummaryResponse;
import co.wom.vulnerabilidades.entities.Vulnerabilities;
import co.wom.vulnerabilidades.entities.Vulnerability;
import co.wom.vulnerabilidades.repositories.IFixedRepository;
import co.wom.vulnerabilidades.repositories.ISummaryRepository;
import co.wom.vulnerabilidades.repositories.IVulnerabilitiesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author USER
 */
@Service
public class VulnerabilitiesService {

    @Autowired
    private IVulnerabilitiesRepository iVulnerabilitiesRepository;
    
    @Autowired
    private ISummaryRepository iSummaryRepository;
    
    
    @Autowired
    private IFixedRepository iFixedRepository;

    public Vulnerabilities CreateVulnerabilities() {
        Vulnerabilities a = new Vulnerabilities();
        a.setId("gg");
        iVulnerabilitiesRepository.save(a);
        return a;
    }
    
    
    public List<Vulnerabilities> listar(){
       return iVulnerabilitiesRepository.findAll();
       
    }
    
//    @Transactional
     public List<Summary> getSummary(){
         
//        List<Summary> fixed = iSummaryRepository.getSummaryFixed();
        List<Summary> total =  iSummaryRepository.getSummaryTotal();
        return total;
//        SummaryResponse sr = new SummaryResponse(total,fixed); 
//        return sr;
    }
    
    public String setAsFixed(String id){
        
        
        if (iFixedRepository.existsById(id)) {
            return "Vulnerability already fixed";
        }
        
        Vulnerabilities v = iVulnerabilitiesRepository.findById(id).get();
        
        if (!iVulnerabilitiesRepository.existsById(id)) {
            return "Vulnerability was not found.";
        }
        Fixed f = new Fixed(id,v.getBaseSeverity());
        iFixedRepository.save(f);
        return "Ok";
    }
    
    
    public List<Vulnerabilities> getNotFixed(){
        return iVulnerabilitiesRepository.getNotFixed();
        
    }

    public void GetCves() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        Root root = restTemplate.getForObject("https://services.nvd.nist.gov/rest/json/cves/2.0", Root.class);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Root> response = restTemplate.exchange("https://services.nvd.nist.gov/rest/json/cves/2.0", HttpMethod.GET, entity, Root.class);
        
        Root root = response.getBody();
        
        ArrayList<Vulnerability> v = root.getVulnerabilities();
        List<Vulnerabilities> records = new ArrayList<>();

        Vulnerabilities tem = new Vulnerabilities();
        int i = 0;

        for (Vulnerability t : v) {
            try {

                records.add(i, new Vulnerabilities());
                tem = records.get(i);
                tem.setId(t.getCve().getId());
                tem.setPublished(t.getCve().getPublished());
                tem.setLastModified(t.getCve().getLastModified());
                tem.setVulnStatus(t.getCve().getVulnStatus());
                tem.setDescription(t.getCve().getDescriptions().get(0).getValue());
                tem.setBaseSeverity(t.getCve().getMetrics().getCvssMetricV2().get(0).getBaseSeverity());

            } catch (Exception E) {

            }
            i++;
        }

        iVulnerabilitiesRepository.saveAll(records);

    }

}

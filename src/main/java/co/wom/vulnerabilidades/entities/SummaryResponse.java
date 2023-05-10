package co.wom.vulnerabilidades.entities;

import java.util.List;
import lombok.Data;

@Data
public class SummaryResponse {

    public SummaryResponse(List<Summary> total, List<Summary> solved) {
        this.total = total;
        this.solved = solved;
    }
    
    
    private List<Summary> total;
    private List<Summary> solved;
}

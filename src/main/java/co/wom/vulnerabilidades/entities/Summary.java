package co.wom.vulnerabilidades.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Summary {
    @Id
    private String baseSeverity;
    private int ammount;
    
}

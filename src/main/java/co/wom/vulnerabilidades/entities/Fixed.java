package co.wom.vulnerabilidades.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import org.hibernate.grammars.hql.HqlParser;



@Entity
@Data
@Table(name = "fixed")
public class Fixed {
   
    public Fixed(String id, String severity){
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.severity = severity; 
        
    }
    
    public Fixed() {
    // Constructor por defecto
    }
    
    @Id
    private String id;
    private LocalDateTime fecha;
    private String severity;
    
}

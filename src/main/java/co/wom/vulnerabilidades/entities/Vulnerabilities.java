package co.wom.vulnerabilidades.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Data;

@Entity
@Data
@Table (name ="vulnerabilities")
public class Vulnerabilities {
    @Id
    private String id;
    private Date published;
    private Date lastModified;
    private String vulnStatus;
    private String description;
    private String baseSeverity;
}

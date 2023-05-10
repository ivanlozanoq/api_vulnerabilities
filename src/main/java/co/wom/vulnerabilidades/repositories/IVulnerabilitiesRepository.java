package co.wom.vulnerabilidades.repositories;

import co.wom.vulnerabilidades.entities.Vulnerabilities;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVulnerabilitiesRepository extends JpaRepository<Vulnerabilities, String> {
    
    @Query(value = "SELECT * FROM vulnerabilities v where v.id not in(select f.id from fixed f);", nativeQuery = true)
    List<Vulnerabilities> getNotFixed();
    
}

package co.wom.vulnerabilidades.repositories;

import co.wom.vulnerabilidades.entities.Summary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISummaryRepository extends JpaRepository<Summary, String> {

    @Query(value = "SELECT v.base_severity, COUNT(1) as ammount FROM vulnerabilities v GROUP BY v.base_severity", nativeQuery = true)
    List<Summary> getSummaryTotal();

    @Query(value = "SELECT v.severity as base_severity, COUNT(1) as ammount FROM fixed v GROUP BY v.severity", nativeQuery = true)
    List<Summary> getSummaryFixed();

}

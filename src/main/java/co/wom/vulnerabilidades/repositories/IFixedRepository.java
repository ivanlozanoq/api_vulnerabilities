package co.wom.vulnerabilidades.repositories;

import co.wom.vulnerabilidades.entities.Fixed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFixedRepository extends JpaRepository<Fixed, String>{
    
}

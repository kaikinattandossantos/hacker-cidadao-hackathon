package Backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.Backend.model.Receptor;

@Repository
public interface Receptorrepository extends JpaRepository<Receptor, Long> {

}

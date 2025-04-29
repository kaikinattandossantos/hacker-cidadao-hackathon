package Backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.Backend.model.Motorista;

@Repository
public interface Motoristarepository extends JpaRepository<Motorista, Long> {

}

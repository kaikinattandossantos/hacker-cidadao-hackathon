package Backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.Backend.model.Transporte;

@Repository
public interface Transporterepository extends JpaRepository<Transporte, Long> {

}

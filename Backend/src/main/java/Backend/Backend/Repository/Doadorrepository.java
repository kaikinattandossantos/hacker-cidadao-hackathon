package Backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.Backend.model.Doador;

@Repository
public interface Doadorrepository extends JpaRepository<Doador, Long> {

}

package Backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.Backend.model.Doacao;

@Repository
public interface Doacaorepository extends JpaRepository<Doacao, Long> {

}

package Backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Backend.Backend.model.Usuario;

@Repository
public interface Usuariorepository extends JpaRepository<Usuario, Long> {

}

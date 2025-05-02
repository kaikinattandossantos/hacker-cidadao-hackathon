package Backend.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.Backend.model.Endereco;

@Repository
public interface Enderecorepository extends JpaRepository<Endereco, String> {

}

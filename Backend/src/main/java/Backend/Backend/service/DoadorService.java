package Backend.Backend.service;

import Backend.Backend.model.Doador;
import Backend.Backend.Repository.Doadorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {

    @Autowired
    private Doadorrepository doadorRepository;

    public Doador salvarDoador(Doador doador) {
        if (doador.getCpfCnpj() == null || doador.getCpfCnpj().isEmpty()) {
            throw new IllegalArgumentException("CPF/CNPJ é obrigatório.");
        }

        return doadorRepository.save(doador);
    }

    public List<Doador> listarDoadores() {
        return doadorRepository.findAll();
    }

    public Optional<Doador> buscarPorId(Long id) {
        return doadorRepository.findById(id);
    }

    public void deletarDoador(Long id) {
        doadorRepository.deleteById(id);
    }
}

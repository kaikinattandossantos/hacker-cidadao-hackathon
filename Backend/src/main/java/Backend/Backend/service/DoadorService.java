package Backend.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.Backend.Repository.Doadorrepository;
import Backend.Backend.model.Doador;

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

    public Optional<Doador> buscarPorId(String id) {
        return doadorRepository.findById(id);
    }

    public void deletarDoador(String id) {
        doadorRepository.deleteById(id);
    }
}

package Backend.Backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.Backend.Repository.Doacaorepository;
import Backend.Backend.Repository.Doadorrepository;
import Backend.Backend.model.Doacao;
import Backend.Backend.model.Doador;
import Backend.Backend.model.StatusDoacao;

@Service
public class DoacaoService {

    @Autowired
    private Doacaorepository doacaoRepository;

    @Autowired
    private Doadorrepository doadorRepository;

    public Doacao salvarDoacao(Doacao doacao, String idDoador) {
        Optional<Doador> doadorOptional = doadorRepository.findById(idDoador);
    
        if (doadorOptional.isEmpty()) {
            throw new IllegalArgumentException("Doador não encontrado");
        }
    
        Doador doador = doadorOptional.get();
        doador.adicionarDoacao(doacao); 
        doadorRepository.save(doador);   
        return doacaoRepository.save(doacao);  
    }
    

    public List<Doacao> listarDoacoes() {
        return doacaoRepository.findAll();
    }

    public Optional<Doacao> buscarPorId(Long id) {
        return doacaoRepository.findById(id);
    }

    public Doacao atualizarStatus(Long id, StatusDoacao novoStatus) {
        Optional<Doacao> doacaoOptional = doacaoRepository.findById(id);

        if (doacaoOptional.isEmpty()) {
            throw new IllegalArgumentException("Doação não encontrada");
        }

        Doacao doacao = doacaoOptional.get();
        doacao.setStatus(novoStatus);
        return doacaoRepository.save(doacao);
    }

    public void deletarDoacao(Long id) {
        doacaoRepository.deleteById(id);
    }
}

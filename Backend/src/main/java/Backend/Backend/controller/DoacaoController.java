package Backend.Backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Backend.Backend.model.Doacao;
import Backend.Backend.model.StatusDoacao;
import Backend.Backend.service.DoacaoService;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping
    public Doacao criar(@RequestBody Doacao doacao, @RequestParam String idDoador) {
        return doacaoService.salvarDoacao(doacao, idDoador);
    }

    @GetMapping
    public List<Doacao> listar() {
        return doacaoService.listarDoacoes();
    }

    @GetMapping("/{id}")
    public Optional<Doacao> buscar(@PathVariable Long id) {
        return doacaoService.buscarPorId(id);
    }

    @PutMapping("/{id}/status")
    public Doacao atualizarStatus(@PathVariable Long id, @RequestBody StatusWrapper novoStatus) {
        return doacaoService.atualizarStatus(id, novoStatus.getStatus());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        doacaoService.deletarDoacao(id);
    }

    public static class StatusWrapper {
        private StatusDoacao status;

        public StatusDoacao getStatus() {
            return status;
        }

        public void setStatus(StatusDoacao status) {
            this.status = status;
        }
    }
}

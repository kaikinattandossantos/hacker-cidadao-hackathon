package Backend.Backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Backend.Backend.model.Doador;
import Backend.Backend.service.DoadorService;

@RestController
@RequestMapping("/doadores")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @PostMapping
    public Doador criarDoador(@RequestBody Doador doador) {
        return doadorService.salvarDoador(doador);
    }

    @GetMapping
    public List<Doador> listarDoadores() {
        return doadorService.listarDoadores();
    }

    @GetMapping("/{id}")
    public Optional<Doador> buscarPorId(@PathVariable Long id) {
        return doadorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        doadorService.deletarDoador(id);
    }
}

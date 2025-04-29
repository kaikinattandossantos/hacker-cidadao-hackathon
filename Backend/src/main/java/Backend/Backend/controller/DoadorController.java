package Backend.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doadores")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @PostMapping
    public Doador cadastrar(@RequestBody Doador doador) {
        return doadorService.salvarDoador(doador);
    }

    @GetMapping
    public List<Doador> listar() {
        return doadorService.listarDoadores();
    }
}

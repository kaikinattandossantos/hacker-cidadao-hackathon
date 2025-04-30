package Backend.Backend.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

@Entity
public class Doador extends Usuario {
    @Column(unique = true)
    private String cpfCnpj;
    
    private String razaoSocial;
    
    @OneToMany(mappedBy = "doador", cascade = CascadeType.ALL)
    private List<Doacao> doacoes = new ArrayList<>();
    
    private Integer pontuacao = 0; 
    
    @Enumerated(EnumType.STRING)
    private PorteDoador porte;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public List<Doacao> getDoacoes() {
        return Collections.unmodifiableList(doacoes); 
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public PorteDoador getPorte() {
        return porte;
    }

    public void setCpfCnpj(String cpfCnpj) {
        if (cpfCnpj == null || (!cpfCnpj.matches("\\d{11}") && !cpfCnpj.matches("\\d{14}"))) {
            throw new IllegalArgumentException("CPF/CNPJ inválido");
        }
        this.cpfCnpj = cpfCnpj;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setPontuacao(Integer pontuacao) {
        if (pontuacao == null || pontuacao < 0) {
            throw new IllegalArgumentException("Pontuação não pode ser negativa");
        }
        this.pontuacao = pontuacao;
        atualizarPorte(); 
    }

    public void setPorte(PorteDoador porte) {
        this.porte = porte;
    }

    public void adicionarDoacao(Doacao doacao) {
        if (doacao == null) {
            throw new IllegalArgumentException("Doação não pode ser nula");
        }
        if (!doacoes.contains(doacao)) {
            doacoes.add(doacao);
            doacao.setDoador(this);
            calcularPontuacao();
        }
    }

    public void removerDoacao(Doacao doacao) {
        if (doacoes.remove(doacao)) {
            doacao.setDoador(null);
            calcularPontuacao();
        }
    }

    private void calcularPontuacao() {
        this.pontuacao = doacoes.stream()
            .filter(d -> d.getStatus() == StatusDoacao.ENTREGUE)
            .mapToInt(d -> 1) 
            .sum();
        
        atualizarPorte();
    }

    private void atualizarPorte() {
        if (pontuacao >= 50) {
            porte = PorteDoador.GRANDE;
        } else if (pontuacao >= 10) {
            porte = PorteDoador.MEDIO;
        } else {
            porte = PorteDoador.PEQUENO;
        }
    }

    public enum PorteDoador {
        PEQUENO,
        MEDIO,
        GRANDE
    }

}
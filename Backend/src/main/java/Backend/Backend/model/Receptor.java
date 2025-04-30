package Backend.Backend.model;

import java.util.List;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Receptor extends Usuario {
    @Column(unique = true)
    private String cpf;
    private Integer membrosFamilia;
    
    @OneToMany(mappedBy = "receptor")
    private List<Match> matches;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getMembrosFamilia() {
        return membrosFamilia;
    }

    public void setMembrosFamilia(Integer membrosFamilia) {
        this.membrosFamilia = membrosFamilia;
    }

}
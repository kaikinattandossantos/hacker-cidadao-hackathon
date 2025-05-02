package Backend.Backend.model;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Receptor extends Usuario {
    @Column(unique = true)
    private String cpf;
    private Integer membrosFamilia;

    @ManyToOne
    @JoinColumn(name = "cep", referencedColumnName = "cep")
    private Endereco endereco;


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

    @Override
    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public enum NivelInseguranca {
        SEVERA,
        MÉDIA, 
        BAIXA
    }

}
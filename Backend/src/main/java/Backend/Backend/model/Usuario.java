package Backend.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false) 
    private String nome;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Embedded
    private Endereco endereco;
    
    private String telefone;
    
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;


    public Long getId() {
        return this.id;
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public TipoUsuario getTipo() {
        return this.tipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public void setEmail(String email) {
        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public enum TipoUsuario {
        DOADOR,
        RECEPTOR,
        COMPOSTAGEM
    }
}
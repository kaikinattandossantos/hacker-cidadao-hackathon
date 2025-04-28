package Backend.Backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity

public class Motorista extends Usuario {
    @Column(unique = true) 
    private String cnh;
    
    private String placaVeiculo;
    private String modeloVeiculo;
    private Integer capacidadeCarga; 
    
    @OneToMany(mappedBy = "motorista")
    private List<Transporte> transportes;
}
package Backend.Backend.model;

import java.util.List;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

@Entity

public class Receptor extends Usuario {
    @Column(unique = true)
    private String cpf;
    private Integer membrosFamilia;
    
    @Enumerated(EnumType.STRING)
    private NivelInsegurancaAlimentar nivelInseguranca; // LEVE, MODERADA, GRAVE
    
    @OneToMany(mappedBy = "receptor")
    private List<Match> matches;
}
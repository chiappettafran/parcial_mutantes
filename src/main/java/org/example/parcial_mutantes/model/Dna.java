package org.example.parcial_mutantes.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Data
public class Dna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000) // Puedes ajustar el tamaño del campo según sea necesario
    private String dnaSequence;

    @Column
    private boolean isMutant;

}

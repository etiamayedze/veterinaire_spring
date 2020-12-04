package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rendezvous")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rendezvous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRV;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "idAnimal"))
    private Animal animal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "idMedecin"))
    private Medecin medecin;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="rendezvous")
    @JsonIgnore
    private List<Ordonnance> ordonnances;

    public Rendezvous() {
    }

    public Rendezvous(Animal animal, Medecin medecin) {
        this.animal = animal;
        this.medecin = medecin;
    }
}

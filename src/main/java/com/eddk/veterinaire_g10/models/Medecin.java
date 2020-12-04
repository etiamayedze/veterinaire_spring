package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "medecin")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedecin;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="medecin")
    @JsonIgnore
    private List<Rendezvous> rendezvous;

    public Medecin() {
    }
}

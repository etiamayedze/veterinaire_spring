package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@EntityScan
@Entity(name = "medecin")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medecin_id;
    private String nom_medecin;
    private String prenom_medecin;
    private String contact;

    @OneToMany(mappedBy="medecin")
    @JsonIgnore
    private List<RendezVous> rendez_vous;

    public Medecin() {
    }


}

package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rendezvous")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rdv_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "animal_id"))
    private Animal animal;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "medecin_id"))
    private Medecin medecin;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="rendez_vous")
    @JsonIgnore
    private List<Ordonnance> ordonnances;

    private String date_rdv;
    private String heure_debut_rdv;
    private String heure_fin_rdv;


    public RendezVous() {
    }



}

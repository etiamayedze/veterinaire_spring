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

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "animal_id"))
    private Animal animal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "medecin_id"))
    private Medecin medecin;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="rendez_vous")
    @JsonIgnore
    private List<Ordonnance> ordonnances;

    private String date_rdv;
    private String heure_debut_rdv;
    private String heure_fin_rdv;

    public RendezVous(Animal animal, Medecin medecin, List<Ordonnance> ordonnances, String date_rdv, String heure_debut_rdv, String heure_fin_rdv) {
        this.animal = animal;
        this.medecin = medecin;
        this.ordonnances = ordonnances;
        this.date_rdv = date_rdv;
        this.heure_debut_rdv = heure_debut_rdv;
        this.heure_fin_rdv = heure_fin_rdv;
    }

    public int getRdv_id() {
        return rdv_id;
    }

    public void setRdv_id(int rdv_id) {
        this.rdv_id = rdv_id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public List<Ordonnance> getOrdonnances() {
        return ordonnances;
    }

    public void setOrdonnances(List<Ordonnance> ordonnances) {
        this.ordonnances = ordonnances;
    }

    public String getDate_rdv() {
        return date_rdv;
    }

    public void setDate_rdv(String date_rdv) {
        this.date_rdv = date_rdv;
    }

    public String getHeure_debut_rdv() {
        return heure_debut_rdv;
    }

    public void setHeure_debut_rdv(String heure_debut_rdv) {
        this.heure_debut_rdv = heure_debut_rdv;
    }

    public String getHeure_fin_rdv() {
        return heure_fin_rdv;
    }

    public void setHeure_fin_rdv(String heure_fin_rdv) {
        this.heure_fin_rdv = heure_fin_rdv;
    }

    public RendezVous() {
    }



}

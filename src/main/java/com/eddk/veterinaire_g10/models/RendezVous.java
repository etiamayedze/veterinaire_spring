package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
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
    @JoinColumn(foreignKey = @ForeignKey(name = "medecin_id"))
    private Medecin medecin;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="rendez_vous")
    private List<Ordonnance> ordonnances;

    private Date daterdv;
    private Date heuredebutrdv;
    private Date heurefinrdv;

    public RendezVous() {
    }

    public RendezVous(Animal animal, Medecin medecin, List<Ordonnance> ordonnances, Date date_rdv, Date heure_debut_rdv, Date heure_fin_rdv) {
        this.animal = animal;
        this.medecin = medecin;
        this.ordonnances = ordonnances;
        this.daterdv = date_rdv;
        this.heuredebutrdv = heure_debut_rdv;
        this.heurefinrdv = heure_fin_rdv;
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

    public Date getDate_rdv() {
        return daterdv;
    }

    public void setDate_rdv(Date date_rdv) {
        this.daterdv = date_rdv;
    }

    public Date getHeure_debut_rdv() {
        return heuredebutrdv;
    }

    public void setHeure_debut_rdv(Date heure_debut_rdv) {
        this.heuredebutrdv = heure_debut_rdv;
    }

    public Date getHeure_fin_rdv() {
        return heurefinrdv;
    }

    public void setHeure_fin_rdv(Date heure_fin_rdv) {
        this.heurefinrdv = heure_fin_rdv;
    }

}

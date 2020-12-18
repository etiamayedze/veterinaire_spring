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
    private String name;
    private String prenom_medecin;
    private String contact;

    @OneToMany(mappedBy="medecin")
    @JsonIgnore
    private List<RendezVous> rendez_vous;

    public Medecin() {
    }

    public String getNom_medecin() {
        return name;
    }

    public void setNom_medecin(String nom_medecin) {
        this.name = nom_medecin;
    }

    public String getPrenom_medecin() {
        return prenom_medecin;
    }

    public void setPrenom_medecin(String prenom_medecin) {
        this.prenom_medecin = prenom_medecin;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

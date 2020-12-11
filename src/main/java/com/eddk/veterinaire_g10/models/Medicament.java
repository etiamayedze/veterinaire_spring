package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "medicament")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicament_id;

    public String nom_medicament;

    public String description;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="medicament")
    @JsonIgnore
    private List<Prescription> prescriptions;


    public Medicament() {
    }

    public int getMedicament_id() {
        return medicament_id;
    }

    public void setMedicament_id(int medicament_id) {
        this.medicament_id = medicament_id;
    }

    public String getNom_medicament() {
        return nom_medicament;
    }

    public void setNom_medicament(String nom_medicament) {
        this.nom_medicament = nom_medicament;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

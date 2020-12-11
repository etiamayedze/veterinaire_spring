package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "prescription")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prescription {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int prescription_id;

    private String date_prescription;
    private String frequence_de_prise;
    private int quantite;


    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "ordonnance_id"))
    private Ordonnance ordonnance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "medicament_id"))
    private Medicament medicament;

    public Prescription(){
    }

    public Prescription(int prescription_id, String date_prescription, String frequence_de_prise, int quantite, Ordonnance ordonnance, Medicament medicament) {
        this.prescription_id = prescription_id;
        this.date_prescription = date_prescription;
        this.frequence_de_prise = frequence_de_prise;
        this.quantite = quantite;
        this.ordonnance = ordonnance;
        this.medicament = medicament;
    }

}

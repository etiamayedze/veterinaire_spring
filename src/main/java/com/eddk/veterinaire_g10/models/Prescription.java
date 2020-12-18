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


    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "ordonnance_id"))
    private Ordonnance ordonnance;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "medicament_id"))
    private Medicament medicament;

    public Prescription(){
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public String getDate_prescription() {
        return date_prescription;
    }

    public void setDate_prescription(String date_prescription) {
        this.date_prescription = date_prescription;
    }

    public String getFrequence_de_prise() {
        return frequence_de_prise;
    }

    public void setFrequence_de_prise(String frequence_de_prise) {
        this.frequence_de_prise = frequence_de_prise;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
}

package com.eddk.veterinaire_g10.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Entity(name = "prescription")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrescription;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "idOrdonnance"))
    private Ordonnance ordonnance;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "idMedicament"))
    private Medicament medicament;

    public Prescription() {
    }

    public Prescription(Ordonnance ordonnance, Medicament medicament) {
        this.ordonnance = ordonnance;
        this.medicament = medicament;
    }
}

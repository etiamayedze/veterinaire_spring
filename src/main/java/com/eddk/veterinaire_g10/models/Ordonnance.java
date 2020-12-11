package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ordonnance")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ordonnance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordonnance_id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "rdv_id"))
    private RendezVous rendez_vous;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="ordonnance")
    @JsonIgnore
    private List<Prescription> prescriptions;

    public Ordonnance() {
    }


    public Ordonnance(RendezVous rendez_vous) {
        this.rendez_vous = rendez_vous;
    }
}

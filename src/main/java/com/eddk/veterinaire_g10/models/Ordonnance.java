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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "rdv_id"))
    private RendezVous rendez_vous;

    @OneToMany(mappedBy="ordonnance")
    @JsonIgnore
    private List<Prescription> prescriptions;

    public Ordonnance(RendezVous rendez_vous, List<Prescription> prescriptions) {
        this.rendez_vous = rendez_vous;
        this.prescriptions = prescriptions;
    }

    public int getOrdonnance_id() {
        return ordonnance_id;
    }

    public void setOrdonnance_id(int ordonnance_id) {
        this.ordonnance_id = ordonnance_id;
    }

    public RendezVous getRendez_vous() {
        return rendez_vous;
    }

    public void setRendez_vous(RendezVous rendez_vous) {
        this.rendez_vous = rendez_vous;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Ordonnance() {
    }


    public Ordonnance(RendezVous rendez_vous) {
        this.rendez_vous = rendez_vous;
    }
}

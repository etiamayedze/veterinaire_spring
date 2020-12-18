package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "animal")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animal_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "parent_id"))
    private Parent parent;

    private String nom_animal;
    private String sex_animal;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="animal")
    private List<RendezVous> rendez_vous;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "type_animal_id"))
    private TypeAnimal type_animal;

    public Animal() {
    }




}

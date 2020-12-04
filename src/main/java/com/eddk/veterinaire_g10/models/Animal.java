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
    private int idAnimal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "idParent"))
    private Parent parent;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "idTypeAnimal"))
    private TypeAnimal typeAnimal;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="animal")
    @JsonIgnore
    private List<Rendezvous> rendezvous;

    public Animal() {
    }

    public Animal(Parent parent, TypeAnimal typeAnimal) {
        this.parent = parent;
        this.typeAnimal = typeAnimal;
    }
}

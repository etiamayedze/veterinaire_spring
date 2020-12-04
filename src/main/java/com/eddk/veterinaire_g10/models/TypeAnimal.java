package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "typeAnimal")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeAnimal;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "typeAnimal")
    @JsonIgnore
    private List<Animal> animals;

    public TypeAnimal() {
    }

}

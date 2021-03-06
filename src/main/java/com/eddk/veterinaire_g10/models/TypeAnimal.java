package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "typeanimal")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int type_animal_id;

    private String libtypeanimal;

    @OneToMany(mappedBy="type_animal")
    @JsonIgnore
    private List<Animal> animals;

    public TypeAnimal() {
    }

    public String getLib_type_animal() {
        return libtypeanimal;
    }

    public void setLib_type_animal(String lib_type_animal) {
        this.libtypeanimal = lib_type_animal;
    }
}

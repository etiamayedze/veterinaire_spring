package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "parent")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parent_id;

    private String nom_parent;
    private String prenom_parent;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="parent")
    @JsonIgnore
    private List<Animal> animals;

    public Parent(){
    }



}

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

    private String name;
    private String prenom_parent;

    @OneToMany(mappedBy="parent")
    @JsonIgnore
    private List<Animal> animals;

    public Parent(int parent_id,String nom_parent,String prenom_parent){
        this.parent_id = parent_id;
        this.name = nom_parent;
        this.prenom_parent = prenom_parent;
    }
    public Parent() {
    }
    public int getParent_id() {
        return parent_id;
    }
    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getNom_parent() {
        return name;
    }
    public void setNom_parent(String nom_parent) {
        this.name=nom_parent;
    }

    public String getPrenom_parent() {
        return prenom_parent;
    }
    public void setPrenom_parent(String prenom_parent) {
        this.prenom_parent=prenom_parent;
    }

}

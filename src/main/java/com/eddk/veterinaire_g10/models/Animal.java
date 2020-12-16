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

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "parent_id"))
    private Parent parent;

    private String nom_animal;
    private String sex_animal;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="animal")
    private List<RendezVous> rendez_vous;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "type_animal_id"))
    private TypeAnimal type_animal;

    public Animal(int animal_id,String nom_animal,String sex_animal,TypeAnimal type_animal) {
    	this.animal_id = animal_id;
    	this.nom_animal = nom_animal;
    	this.sex_animal = sex_animal;
    	this.type_animal = type_animal;
    }
    
    public int getAnimal_id() {
    	return animal_id;
    }
    public void setAnimal_id(int animal_id) {
    	this.animal_id = animal_id;
    }
    
    public String getNom_animal() {
    	return nom_animal;
    }
    public void setNom_animal(String nom_animal) {
    	this.nom_animal=nom_animal;
    }
    
    public String getSex_animal() {
    	return sex_animal;
    }
    public void setSex_animal(String sex_animal) {
    	this.sex_animal=sex_animal;
    }
    
    public TypeAnimal getType_animal() {
    	return type_animal;
    }
    public void setType_animal(TypeAnimal type_animal) {
    	this.type_animal=type_animal;
    }


}

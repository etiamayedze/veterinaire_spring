package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import com.eddk.veterinaire_g10.repositories.TypeAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/typesanimal")
public class TypesAnimal {
    @Autowired
    private TypeAnimalRepository typeAnimalRepository;
    // get all type animal
    @GetMapping
    public List<TypeAnimal> getAllTypeAnimal(){
        return this.typeAnimalRepository.findAll();
    }
    // get type animal by id
    @GetMapping("/{id}")
    public TypeAnimal getTypeAnimalById(@PathVariable(value = "id") Integer type_animal_id){
        return this.typeAnimalRepository.findById(type_animal_id).orElseThrow(()-> new RessourceNotFoundException("Type animal not found with id :"+type_animal_id));
    }
    //create type animal
    @PostMapping
    public TypeAnimal createTypeAnimal(@RequestBody TypeAnimal typeAnimal){
        return this.typeAnimalRepository.save(typeAnimal);
    }
    // update type animal
    @PutMapping("/{id}")
    public TypeAnimal updateTypeAnimal(@RequestBody TypeAnimal typeAnimal, @PathVariable ("id") Integer type_animal_id){
        TypeAnimal existingType = this.typeAnimalRepository.findById(type_animal_id)
                .orElseThrow(()-> new RessourceNotFoundException("Type animal not found with id :"+type_animal_id));
        existingType.setLib_type_animal(typeAnimal.getLib_type_animal());
        return this.typeAnimalRepository.save(existingType);
    }
    // Delete type animal by id
    @DeleteMapping("/{id}")
    public ResponseEntity<TypeAnimal> deleteTypeAnimal (@PathVariable ("id") Integer type_animal_id){
        TypeAnimal existingType = this.typeAnimalRepository.findById(type_animal_id)
                .orElseThrow(()-> new RessourceNotFoundException("Type animal not found with id :"+type_animal_id));
        this.typeAnimalRepository.delete(existingType);
        return ResponseEntity.ok().build();

    }
}

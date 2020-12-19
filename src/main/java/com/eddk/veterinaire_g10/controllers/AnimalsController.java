package com.eddk.veterinaire_g10.controllers;

import java.util.List;
import java.util.Optional;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.Medecin;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import com.eddk.veterinaire_g10.repositories.TypeAnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.repositories.AnimalRepository;

@RestController
@RequestMapping("/api/v0/animals")
public class AnimalsController {
	@Autowired
	private AnimalRepository animalRepository;
	// get all type animal
	@GetMapping
	public List<Animal> getAllAnimal(){
		return this.animalRepository.findAll();
	}
	// get animal by id
	@GetMapping("/{id}")
	public Animal getAnimalById(@PathVariable(value = "id") Integer animal_id){
		return this.animalRepository.findById(animal_id).orElseThrow(()-> new RessourceNotFoundException(" animal not found with id :"+animal_id));
	}
	//create type animal
	@PostMapping
	public Animal createAnimal(@RequestBody Animal animal){
		return this.animalRepository.save(animal);
	}
	// update type animal


	@RequestMapping(value = "{id}", method= RequestMethod.PUT)
	public Animal update(@PathVariable int id, @RequestBody Animal animal){
		Animal existingAnimal = animalRepository.getOne(id);
		BeanUtils.copyProperties(animal, existingAnimal, "animal_id");
		return animalRepository.saveAndFlush(existingAnimal);
	}
	// Delete type animal by id
	@DeleteMapping("/{id}")
	public ResponseEntity<TypeAnimal> deleteTypeAnimal (@PathVariable ("id") Integer animal_id){
		Animal existingType = this.animalRepository.findById(animal_id)
				.orElseThrow(()-> new RessourceNotFoundException("Type animal not found with id :"+animal_id));
		this.animalRepository.delete(existingType);
		return ResponseEntity.ok().build();

	}

	@GetMapping(value = "/recherche/{recherche}")
	public List<Animal> searchForEntity(@PathVariable String recherche) {
		return animalRepository.findByNomanimalLike("%"+recherche+"%");
	}
    
}

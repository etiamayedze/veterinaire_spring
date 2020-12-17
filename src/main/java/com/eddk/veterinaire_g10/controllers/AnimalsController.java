package com.eddk.veterinaire_g10.controllers;

import java.util.List;
import java.util.Optional;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import com.eddk.veterinaire_g10.repositories.TypeAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PutMapping("/{id}")
	public Animal updateAnimal(@RequestBody Animal animal, @PathVariable ("id") Integer animal_id){
		Animal existingType = this.animalRepository.findById(animal_id)
				.orElseThrow(()-> new RessourceNotFoundException("Type animal not found with id :"+animal_id));
		existingType.setNom_animal(animal.getNom_animal());
		existingType.setSex_animal(animal.getSex_animal());
		return this.animalRepository.save(existingType);
	}
	// Delete type animal by id
	@DeleteMapping("/{id}")
	public ResponseEntity<TypeAnimal> deleteTypeAnimal (@PathVariable ("id") Integer animal_id){
		Animal existingType = this.animalRepository.findById(animal_id)
				.orElseThrow(()-> new RessourceNotFoundException("Type animal not found with id :"+animal_id));
		this.animalRepository.delete(existingType);
		return ResponseEntity.ok().build();

	}

//	@Autowired
//	AnimalRepository animalrepository;
//
//	@GetMapping("/getAllAnimals")
//	public List<Animal>getAllAnimals()
//	{
//		return animalrepository.findAll();
//	}
//
//	@GetMapping("/getAnimalById/{animal_id}")
//	public Optional<Animal>getAnimalById(@PathVariable(value="animal_id")int animal_id)
//	{
//		return animalrepository.findById(animal_id);
//	}
//
//	@PostMapping("/addAnimal")
//	public Animal addAnimal(@RequestBody Animal animal)
//	{
//		return animalrepository.save(animal);
//	}
//
//	@PutMapping("/updateAnimal/{animal_id}")
//	public Animal updateAnimal(@PathVariable(value="animal_id") int animal_id,@RequestBody Animal animalDetails)
//	{
//		Optional<Animal>animal=animalrepository.findById(animal_id);
//		Animal animal_new=animal.get();
//		animal_new.setNom_animal(animalDetails.getNom_animal());
//		animal_new.setSex_animal(animalDetails.getSex_animal());
//		animal_new.setType_animal(animalDetails.getType_animal());
//		return animalrepository.save(animal_new);
//	}
//
//	@DeleteMapping("/deleteAnimal/{animal_id}")
//	public void deleteBook(@PathVariable(value="animal_id")int animal_id) {
//		Optional<Animal>animal=animalrepository.findById(animal_id);
//		Animal animal_new=animal.get();
//		animalrepository.delete(animal_new);
//	}
    
}

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

import com.eddk.veterinaire_g10.models.Parent;
import com.eddk.veterinaire_g10.repositories.ParentRepository;

@RestController
@RequestMapping("/api/v0/parents")
public class ParentsController {
	@Autowired
	private ParentRepository parentRepository;
	// get all parent animal
	@GetMapping
	public List<Parent> getAllParents(){
		return this.parentRepository.findAll();
	}
	// get parent animal by id
	@GetMapping("/{id}")
	public Parent getParentById(@PathVariable(value = "id") Integer parent_id){
		return this.parentRepository.findById(parent_id).orElseThrow(()-> new RessourceNotFoundException("Parent animal not found with id :"+parent_id));
	}
	//create Parent animal
	@PostMapping
	public Parent createParent(@RequestBody Parent parent){
		return this.parentRepository.save(parent);
	}
	// update Parent animal
	@PutMapping("/{id}")
	public Parent updateParent(@RequestBody Parent parent, @PathVariable ("id") Integer parent_id){
		Parent existingType = this.parentRepository.findById(parent_id)
				.orElseThrow(()-> new RessourceNotFoundException("Parent not found with id :"+parent_id));
		existingType.setNom_parent(parent.getNom_parent());
		existingType.setPrenom_parent(parent.getPrenom_parent());
		return this.parentRepository.save(existingType);
	}
	// Delete parent by id
	@DeleteMapping("/{id}")
	public ResponseEntity<TypeAnimal> deleteParent (@PathVariable ("id") Integer parent_id){
		Parent existingType = this.parentRepository.findById(parent_id)
				.orElseThrow(()-> new RessourceNotFoundException("Parent not found with id :"+parent_id));
		this.parentRepository.delete(existingType);
		return ResponseEntity.ok().build();

	}
//	@Autowired
//	ParentRepository parentRepository;
//
//	@GetMapping("/getAllParents")
//	public List<Parent>getAllParents()
//	{
//		return parentRepository.findAll();
//	}
//
//	@GetMapping("/getParentById/{parent_id}")
//	public Optional<Parent>getParentById(@PathVariable(value="parent_id")int parent_id)
//	{
//		return parentRepository.findById(parent_id);
//	}
//
//	@PostMapping("/addParent")
//	public Parent addParent(@RequestBody Parent parent)
//	{
//		return parentRepository.save(parent);
//	}
//
//	@PutMapping("/updateParent/{parent_id}")
//	public Parent updateParent(@PathVariable(value="parent_id") int parent_id,@RequestBody Parent parentDetails)
//	{
//		Optional<Parent>parent=parentRepository.findById(parent_id);
//		Parent parent_new=parent.get();
//		parent_new.setNom_parent(parentDetails.getNom_parent());
//		parent_new.setPrenom_parent(parentDetails.getPrenom_parent());
//		return parentRepository.save(parent_new);
//	}
//
//	@DeleteMapping("/deleteParent/{parent_id}")
//	public void deleteBook(@PathVariable(value="parent_id")int parent_id) {
//		Optional<Parent>parent=parentRepository.findById(parent_id);
//		Parent parent_new=parent.get();
//		parentRepository.delete(parent_new);
//	}
}

package com.eddk.veterinaire_g10.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	ParentRepository parentRepository;
	
	@GetMapping("/getAllParents")
	public List<Parent>getAllParents()
	{
		return parentRepository.findAll();
	}
	
	@GetMapping("/getParentById/{parent_id}")
	public Optional<Parent>getParentById(@PathVariable(value="parent_id")int parent_id)
	{
		return parentRepository.findById(parent_id);
	}
	
	@PostMapping("/addParent")
	public Parent addParent(@RequestBody Parent parent)
	{
		return parentRepository.save(parent);
	}
	
	@PutMapping("/updateParent/{parent_id}")
	public Parent updateParent(@PathVariable(value="parent_id") int parent_id,@RequestBody Parent parentDetails)
	{
		Optional<Parent>parent=parentRepository.findById(parent_id);
		Parent parent_new=parent.get();
		parent_new.setNom_parent(parentDetails.getNom_parent());
		parent_new.setPrenom_parent(parentDetails.getPrenom_parent());
		return parentRepository.save(parent_new);
	}
	
	@DeleteMapping("/deleteParent/{parent_id}")
	public void deleteBook(@PathVariable(value="parent_id")int parent_id) {
		Optional<Parent>parent=parentRepository.findById(parent_id);
		Parent parent_new=parent.get();
		parentRepository.delete(parent_new);
	}
}

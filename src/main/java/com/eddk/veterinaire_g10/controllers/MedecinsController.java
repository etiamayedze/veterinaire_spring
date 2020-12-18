package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.Medecin;
import com.eddk.veterinaire_g10.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/medecins")
public class MedecinsController {
    @Autowired
    private MedecinRepository medecinRepository;
    // get all Medecins
    @GetMapping
    public List<Medecin> getAllMedecins(){
        return this.medecinRepository.findAll();
    }
    // get medecin by id
    @GetMapping("/{id}")
    public Medecin getMedecinById(@PathVariable(value = "id") Integer medecin_id){
        return this.medecinRepository.findById(medecin_id).orElseThrow(()-> new RessourceNotFoundException("Medecin not found with id :"+medecin_id));
    }
    //create medecin
    @PostMapping
    public Medecin createMedecin(@RequestBody Medecin medecin){
        return this.medecinRepository.save(medecin);
    }
    // update medecin
    @PutMapping("/{id}")
    public Medecin updateMedecin(@RequestBody Medecin medecin, @PathVariable ("id") Integer medecin_id){
        Medecin existingMedecin = this.medecinRepository.findById(medecin_id)
                .orElseThrow(()-> new RessourceNotFoundException("Medecin not found with id :"+medecin_id));
        existingMedecin.setNom_medecin(medecin.getNom_medecin());
        existingMedecin.setPrenom_medecin(medecin.getPrenom_medecin());
        existingMedecin.setContact(medecin.getContact());
        return this.medecinRepository.save(existingMedecin);
    }
    // Delete medecin by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Medecin> deleteMedecin (@PathVariable ("id") Integer medecin_id){
        Medecin existingMedecin = this.medecinRepository.findById(medecin_id)
                .orElseThrow(()-> new RessourceNotFoundException("Medecin not found with id :"+medecin_id));
        this.medecinRepository.delete(existingMedecin);
        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/recherche/{recherche}")
    public List<Medecin> searchForEntity(@PathVariable String recherche) {
        return medecinRepository.findByNameLike("%"+recherche+"%");
    }
}

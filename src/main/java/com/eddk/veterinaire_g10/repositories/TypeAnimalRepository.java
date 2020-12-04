package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAnimalRepository extends JpaRepository<TypeAnimal, Integer> {
}

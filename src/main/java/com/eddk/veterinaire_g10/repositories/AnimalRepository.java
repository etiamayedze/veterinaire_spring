package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository  extends JpaRepository<Animal, Integer>  {
}

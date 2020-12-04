package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Integer> {
}

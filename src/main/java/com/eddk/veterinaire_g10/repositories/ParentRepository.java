package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
}

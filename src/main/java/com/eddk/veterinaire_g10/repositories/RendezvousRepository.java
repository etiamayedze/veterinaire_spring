package com.eddk.veterinaire_g10.repositories;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.models.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<Rendezvous, Integer> {
}

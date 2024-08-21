package com.fastDelivery.repo;


import com.fastDelivery.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("personne_repo")
public interface PersonneRepository extends JpaRepository<Personne,Long> {


    List<Personne> findByNomIgnoreCaseAndPrenomIgnoreCaseAndIdPersonneNot(String nom, String prenom, long clientReqId);

    List<Personne> findByNomIgnoreCaseAndPrenomIgnoreCase(String nom, String prenom);
}

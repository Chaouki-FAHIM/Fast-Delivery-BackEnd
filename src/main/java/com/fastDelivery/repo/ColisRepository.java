package com.fastDelivery.repo;

import com.fastDelivery.entities.Colis;
import com.fastDelivery.enumerator.StatutColis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("colis_repo")
public interface ColisRepository extends JpaRepository<Colis, Long> {
    List<Colis> findAllByStatutAndDateStatutRefuseBefore(StatutColis statutColis, Date date);

    Page<Colis> findByStatut(StatutColis statutColis, Pageable pageable);
}

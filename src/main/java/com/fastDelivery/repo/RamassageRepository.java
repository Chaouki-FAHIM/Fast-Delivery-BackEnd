package com.fastDelivery.repo;

import com.fastDelivery.entities.Ramassage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ramassage_repo")
public interface RamassageRepository extends JpaRepository<Ramassage, Long> {

}

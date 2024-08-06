package com.fastDelivery.repo;


import com.fastDelivery.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("client_repo")
public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByEmailAndPassword(String email, String password);
}

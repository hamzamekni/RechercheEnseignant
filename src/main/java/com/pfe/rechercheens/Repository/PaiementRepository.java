package com.pfe.rechercheens.Repository;


import com.pfe.rechercheens.Entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository  extends JpaRepository<Paiement,Long> {
}

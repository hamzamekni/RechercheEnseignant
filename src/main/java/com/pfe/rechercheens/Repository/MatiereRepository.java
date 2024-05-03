package com.pfe.rechercheens.Repository;

import com.pfe.rechercheens.Entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Long> {
}

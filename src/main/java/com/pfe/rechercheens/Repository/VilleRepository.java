package com.pfe.rechercheens.Repository;
import com.pfe.rechercheens.Entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Long> {
}

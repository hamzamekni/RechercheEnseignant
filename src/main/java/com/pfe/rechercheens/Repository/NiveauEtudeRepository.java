package com.pfe.rechercheens.Repository;
import com.pfe.rechercheens.Entity.NiveauEtude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauEtudeRepository extends JpaRepository<NiveauEtude,Long> {
}

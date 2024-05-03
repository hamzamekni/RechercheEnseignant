package com.pfe.rechercheens.Repository;
import com.pfe.rechercheens.Entity.DemandeDeCour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeDeCourRepository extends JpaRepository<DemandeDeCour,Long> {
}

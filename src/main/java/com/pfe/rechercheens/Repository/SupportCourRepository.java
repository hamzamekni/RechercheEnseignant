package com.pfe.rechercheens.Repository;
import com.pfe.rechercheens.Entity.SupportCour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportCourRepository extends JpaRepository<SupportCour,Long> {
}

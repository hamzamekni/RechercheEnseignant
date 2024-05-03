package com.pfe.rechercheens.Repository;

import com.pfe.rechercheens.Entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {
}

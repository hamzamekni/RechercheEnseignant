package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Recommendation;

import java.util.List;

public interface RecommendationService {
    Recommendation saveRecommendation(Recommendation recommendation);
    Recommendation updateRecommendation(Long id, Recommendation updatedRecommendation);
    void deleteRecommendation(Long id);
    Recommendation getRecommendationById(Long id);
    List<Recommendation> getAllRecommendations();
}

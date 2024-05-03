package com.pfe.rechercheens.ServiceImpl;

import com.pfe.rechercheens.Entity.Recommendation;
import com.pfe.rechercheens.Repository.RecommendationRepository;
import com.pfe.rechercheens.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public Recommendation saveRecommendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    @Override
    public Recommendation updateRecommendation(Long id, Recommendation updatedRecommendation) {
        Recommendation existingRecommendation = recommendationRepository.findById(id).orElse(null);
        if (existingRecommendation != null) {
            updatedRecommendation.setRecommendationId(existingRecommendation.getRecommendationId());
            return recommendationRepository.save(updatedRecommendation);
        }
        return null;
    }

    @Override
    public void deleteRecommendation(Long id) {
        recommendationRepository.deleteById(id);
    }

    @Override
    public Recommendation getRecommendationById(Long id) {
        return recommendationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }
}

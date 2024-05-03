package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.DemandeDeCour;

import java.util.List;

public interface DemandeDeCourService {
    DemandeDeCour saveDemandeDeCour(DemandeDeCour demandeDeCour);
    DemandeDeCour updateDemandeDeCour(Long id, DemandeDeCour updatedDemandeDeCour);
    void deleteDemandeDeCour(Long id);
    DemandeDeCour getDemandeDeCourById(Long id);
    List<DemandeDeCour> getAllDemandeDeCours();
}

package com.pfe.rechercheens.ServiceImpl;

import com.pfe.rechercheens.Entity.DemandeDeCour;
import com.pfe.rechercheens.Repository.DemandeDeCourRepository;
import com.pfe.rechercheens.Service.DemandeDeCourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandeDeCourServiceImpl implements DemandeDeCourService {

    @Autowired
    private DemandeDeCourRepository demandeDeCourRepository;

    @Override
    public DemandeDeCour saveDemandeDeCour(DemandeDeCour demandeDeCour) {
        return demandeDeCourRepository.save(demandeDeCour);
    }

    @Override
    public DemandeDeCour updateDemandeDeCour(Long id, DemandeDeCour updatedDemandeDeCour) {
        DemandeDeCour existingDemandeDeCour = demandeDeCourRepository.findById(id).orElse(null);
        if (existingDemandeDeCour != null) {
            updatedDemandeDeCour.setDemandeDeCour_Id(existingDemandeDeCour.getDemandeDeCour_Id());
            return demandeDeCourRepository.save(updatedDemandeDeCour);
        }
        return null;
    }

    @Override
    public void deleteDemandeDeCour(Long id) {
        demandeDeCourRepository.deleteById(id);
    }

    @Override
    public DemandeDeCour getDemandeDeCourById(Long id) {
        return demandeDeCourRepository.findById(id).orElse(null);
    }

    @Override
    public List<DemandeDeCour> getAllDemandeDeCours() {
        return demandeDeCourRepository.findAll();
    }
}


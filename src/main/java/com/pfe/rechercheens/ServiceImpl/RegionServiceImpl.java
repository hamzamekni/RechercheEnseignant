package com.pfe.rechercheens.ServiceImpl;

import com.pfe.rechercheens.Entity.Region;
import com.pfe.rechercheens.Repository.RegionRepository;
import com.pfe.rechercheens.Service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region updateRegion(Long id, Region updatedRegion) {
        Region existingRegion = regionRepository.findById(id).orElse(null);
        if (existingRegion != null) {
            updatedRegion.setRegion_Id(existingRegion.getRegion_Id());
            return regionRepository.save(updatedRegion);
        }
        return null;
    }

    @Override
    public void deleteRegion(Long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public Region getRegionById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}
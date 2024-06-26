package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Region;

import java.util.List;

public interface RegionService {
    Region saveRegion(Region region);
    Region updateRegion(Long id, Region updatedRegion);
    void deleteRegion(Long id);
    Region getRegionById(Long id);
    List<Region> getAllRegions();
}

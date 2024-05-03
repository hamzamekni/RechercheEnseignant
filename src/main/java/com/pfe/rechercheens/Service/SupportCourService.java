package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.SupportCour;

import java.util.List;

public interface SupportCourService {
    SupportCour saveSupportCour(SupportCour supportCour);
    SupportCour updateSupportCour(Long id, SupportCour updatedSupportCour);
    void deleteSupportCour(Long id);
    SupportCour getSupportCourById(Long id);
    List<SupportCour> getAllSupportCours();
}

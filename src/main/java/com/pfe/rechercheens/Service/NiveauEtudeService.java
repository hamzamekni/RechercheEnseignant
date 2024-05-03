package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.NiveauEtude;

import java.util.List;

public interface NiveauEtudeService {
    NiveauEtude saveNiveauEtude(NiveauEtude niveauEtude);
    NiveauEtude updateNiveauEtude(Long id, NiveauEtude updatedNiveauEtude);
    void deleteNiveauEtude(Long id);
    NiveauEtude getNiveauEtudeById(Long id);
    List<NiveauEtude> getAllNiveauEtudes();
}

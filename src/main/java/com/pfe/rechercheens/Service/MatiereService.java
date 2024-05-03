package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Matiere;

import java.util.List;

public interface MatiereService {
    List<Matiere> getAllMatieres();
    Matiere getMatiereById(Long id);
    Matiere saveMatiere(Matiere matiere);
    void deleteMatiereById(Long id);
}

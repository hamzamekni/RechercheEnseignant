package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Long id, Etudiant updatedEtudiant);
    void deleteEtudiant(Long id);
    Etudiant getEtudiantById(Long id);
    List<Etudiant> getAllEtudiants();
}

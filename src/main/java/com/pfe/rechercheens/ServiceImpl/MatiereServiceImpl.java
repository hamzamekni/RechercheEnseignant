package com.pfe.rechercheens.ServiceImpl;

import com.pfe.rechercheens.Entity.Matiere;
import com.pfe.rechercheens.Repository.MatiereRepository;
import com.pfe.rechercheens.Service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereServiceImpl implements MatiereService {
    @Autowired
    private MatiereRepository matiereRepository;

    @Override
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere getMatiereById(Long id) {
        Optional<Matiere> matiereOptional = matiereRepository.findById(id);
        return matiereOptional.orElse(null);
    }

    @Override
    public Matiere saveMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public void deleteMatiereById(Long id) {
        matiereRepository.deleteById(id);
    }
}

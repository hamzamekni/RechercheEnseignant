package com.pfe.rechercheens.ServiceImpl;
import com.pfe.rechercheens.Entity.Adress;
import com.pfe.rechercheens.Repository.AdressRepository;
import com.pfe.rechercheens.Service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressServiceImpl implements AdressService {
    @Autowired
    private AdressRepository adressRepository;

    @Override
    public List<Adress> getAllAdresses() {
        return adressRepository.findAll();
    }

    @Override
    public Adress getAdressById(Long id) {
        Optional<Adress> adressOptional = adressRepository.findById(id);
        return adressOptional.orElse(null);
    }

    @Override
    public Adress saveAdress(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public Adress updateAdress(Long id, Adress updatedAdress) {
        Adress existingAdress = adressRepository.findById(id).orElse(null);
        if (existingAdress != null) {
            updatedAdress.setAdress_Id(existingAdress.getAdress_Id());
            return adressRepository.save(updatedAdress);
        }
        return null;
    }

    @Override
    public void deleteAdressById(Long id) {
        adressRepository.deleteById(id);
    }
}

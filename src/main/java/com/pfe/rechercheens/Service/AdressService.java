package com.pfe.rechercheens.Service;

import com.pfe.rechercheens.Entity.Adress;

import java.util.List;

public interface AdressService {
    List<Adress> getAllAdresses();
    Adress getAdressById(Long id);
    Adress saveAdress(Adress adress);
    Adress updateAdress(Long id, Adress updatedAdress);
    void deleteAdressById(Long id);
}

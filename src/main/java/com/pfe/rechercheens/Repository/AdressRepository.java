package com.pfe.rechercheens.Repository;

import com.pfe.rechercheens.Entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress,Long> {

}

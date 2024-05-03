package com.pfe.rechercheens.Repository;

import com.pfe.rechercheens.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>  {



}

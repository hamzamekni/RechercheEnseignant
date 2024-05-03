package com.pfe.rechercheens.Repository;

import com.pfe.rechercheens.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>  {


    Optional<Object> findByEmail(String email);

    Object getUserByEmail(String userEmail);
}

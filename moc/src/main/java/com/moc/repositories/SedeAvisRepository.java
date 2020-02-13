package com.moc.repositories;

import com.moc.models.SedeAvis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SedeAvisRepository
 */
@Repository
public interface SedeAvisRepository extends JpaRepository<SedeAvis,Long>{

	SedeAvis findByComune(String comune);

	SedeAvis findByEmail(String email);

    
}
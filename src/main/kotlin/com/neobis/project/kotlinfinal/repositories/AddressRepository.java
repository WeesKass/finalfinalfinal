package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}

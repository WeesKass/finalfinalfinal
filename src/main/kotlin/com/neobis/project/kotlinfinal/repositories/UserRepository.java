package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}

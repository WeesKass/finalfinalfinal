package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    void deleteCustomerEntitiesByAddressId(int addressId);
}

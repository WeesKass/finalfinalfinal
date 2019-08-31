package com.neobis.project.kotlinfinal.repositories;

import com.neobis.project.kotlinfinal.entities.CustomerEntity;
import com.neobis.project.kotlinfinal.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    void deleteCustomerEntitiesByAddressId(int addressId);

    CustomerEntity findByUserId(int customerId);
}

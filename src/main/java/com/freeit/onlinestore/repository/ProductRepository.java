package com.freeit.onlinestore.repository;

import com.freeit.onlinestore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByMotherboard_Id(UUID id);

    Optional<Product> deleteByMotherboard_Id(UUID id);

    Optional<Product> findByProcessor_Id(UUID id);

    Optional<Product> deleteByProcessor_Id(UUID id);

    Optional<Product> findByRam_Id(UUID id);

    Optional<Product> deleteByRam_Id(UUID id);

    Optional<Product> findByVideocard_Id(UUID id);

    Optional<Product> deleteByVideocard_Id(UUID id);
}

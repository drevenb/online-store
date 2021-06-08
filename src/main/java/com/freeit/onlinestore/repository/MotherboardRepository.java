package com.freeit.onlinestore.repository;

import com.freeit.onlinestore.entity.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, UUID> {
}

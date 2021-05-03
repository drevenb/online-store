package com.freeit.onlinestore.repository;

import com.freeit.onlinestore.entity.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MotherboardRepository extends JpaRepository<Motherboard, UUID> {
}

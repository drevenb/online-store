package com.freeit.onlinestore.repository;

import com.freeit.onlinestore.entity.Processor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProcessorRepository extends JpaRepository<Processor, UUID> {
}

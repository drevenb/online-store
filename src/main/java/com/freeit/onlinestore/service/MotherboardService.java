package com.freeit.onlinestore.service;

import com.freeit.onlinestore.dto.req.NewMotherboardDto;
import com.freeit.onlinestore.dto.resp.MotherboardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MotherboardService {

    Page<MotherboardDto> getAllMotherboards(Pageable pageable);

    MotherboardDto getMotherboard(UUID id);

    MotherboardDto updateMotherboard(UUID id, NewMotherboardDto newBoard);

    boolean deleteMotherboard(UUID id);

    MotherboardDto saveMotherboard(NewMotherboardDto newBoard);
}

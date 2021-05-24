package com.freeit.onlinestore.service;

import com.freeit.onlinestore.dto.req.NewMotherboardDto;
import com.freeit.onlinestore.dto.resp.MotherboardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MotherboardService {

    Page<MotherboardDto> getAllMotherboards(Pageable pageable);

    MotherboardDto getMotherboard(Long id);

    MotherboardDto updateMotherboard(Long id, NewMotherboardDto newBoard);

    boolean deleteMotherboard(Long id);

    MotherboardDto saveMotherboard(NewMotherboardDto newBoard);
}

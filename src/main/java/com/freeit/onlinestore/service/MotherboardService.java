package com.freeit.onlinestore.service;

import com.freeit.onlinestore.dto.MotherboardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MotherboardService {

    Page<MotherboardDto> getAllMotherboards(Pageable pageable);
}

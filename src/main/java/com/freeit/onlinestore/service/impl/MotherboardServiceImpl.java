package com.freeit.onlinestore.service.impl;

import com.freeit.onlinestore.dto.MotherboardDto;
import com.freeit.onlinestore.entity.Motherboard;
import com.freeit.onlinestore.repository.MotherboardRepository;
import com.freeit.onlinestore.service.MotherboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MotherboardServiceImpl implements MotherboardService {

    private final MotherboardRepository motherboardRepository;

    @Override
    public Page<MotherboardDto> getAllMotherboards(Pageable pageable) {
        Page<Motherboard> page = motherboardRepository.findAll(pageable);
        List<MotherboardDto> motherboardDto = page.get()
                .map(board -> new MotherboardDto(board.getId(), board.getMemorySlots(), board.getFormFactor(),
                                                board.getMemoryType(), board.getMotherboardProducer(), board.getSocket()))
                .collect(Collectors.toList());
        return new PageImpl<>(motherboardDto);
    }
}

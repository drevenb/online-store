package com.freeit.onlinestore.service.impl;

import com.freeit.onlinestore.dto.req.NewMotherboardDto;
import com.freeit.onlinestore.dto.resp.MotherboardDto;
import com.freeit.onlinestore.entity.Motherboard;
import com.freeit.onlinestore.entity.Product;
import com.freeit.onlinestore.exception.DBNotFoundException;
import com.freeit.onlinestore.mapper.motherboard.MotherboardMapper;
import com.freeit.onlinestore.mapper.motherboard.NewMotherboardMapper;
import com.freeit.onlinestore.repository.MotherboardRepository;
import com.freeit.onlinestore.repository.ProductRepository;
import com.freeit.onlinestore.service.MotherboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MotherboardServiceImpl implements MotherboardService {

    private final String NOT_FOUND_MESSAGE = "There is not such element in database";

    private final ProductRepository productRepository;
    private final MotherboardRepository motherboardRepository;

    private final MotherboardMapper motherboardMapper;
    private final NewMotherboardMapper newMotherboardMapper;

    @Override
    public PageImpl getAllMotherboards(Pageable pageable) {
        List<MotherboardDto> motherboardDtoList = motherboardMapper.toDto(motherboardRepository.findAll());
        log.debug("Motherboard Dto List: {}", motherboardDtoList);
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), motherboardDtoList.size());
        return new PageImpl<>(motherboardDtoList.subList(start, end), pageable, motherboardDtoList.size());
    }

    @Override
    public MotherboardDto getMotherboard(UUID id) {
        Motherboard motherboard = motherboardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        log.debug("Motherboard is found: {}", motherboard);
        return motherboardMapper.toDto(motherboard);
    }

    @Override
    public MotherboardDto updateMotherboard(UUID id, NewMotherboardDto newBoard) {
        Motherboard motherboard = motherboardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        log.debug("Motherboard is ready to update: {}", motherboard);

        motherboard.setName(newBoard.getName());
        motherboard.setSocket(newBoard.getSocket());
        motherboard.setProducer(newBoard.getProducer());
        motherboard.setFormFactor(newBoard.getFormFactor());
        motherboard.setMemorySlots(newBoard.getMemorySlots());
        motherboard.setMemoryType(newBoard.getMemoryType());
        motherboard.setPrice(newBoard.getPrice());
        motherboard.setRemainder(newBoard.getRemainder());

        Motherboard updatedBoard = motherboardRepository.save(motherboard);
        log.debug("Motherboard is updated: {}", updatedBoard);
        return motherboardMapper.toDto(updatedBoard);
    }

    @Override
    public boolean deleteMotherboard(UUID id) {
        if(!motherboardRepository.existsById(id)) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        }
        log.debug("Motherboard was deleted: {}", productRepository.deleteByMotherboard_Id(id));
        return true;
    }

    @Override
    public MotherboardDto saveMotherboard(NewMotherboardDto newBoard) {
        Motherboard motherboard = motherboardRepository.save(newMotherboardMapper.toEntity(newBoard));
        Product product = new Product(motherboard, null, null, null, null);
        productRepository.save(product);
        log.debug("Motherboard created: {}", product);
        return motherboardMapper.toDto(motherboard);
    }
}

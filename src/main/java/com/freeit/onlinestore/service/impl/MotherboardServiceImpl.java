package com.freeit.onlinestore.service.impl;

import com.freeit.onlinestore.dto.req.NewMotherboardDto;
import com.freeit.onlinestore.dto.resp.MotherboardDto;
import com.freeit.onlinestore.entity.Motherboard;
import com.freeit.onlinestore.entity.Product;
import com.freeit.onlinestore.exception.DBNotFoundException;
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
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MotherboardServiceImpl implements MotherboardService {

    private final ProductRepository productRepository;
    private final MotherboardRepository motherboardRepository;

    @Override
    public PageImpl getAllMotherboards(Pageable pageable) {
        List<Motherboard> motherboardList = motherboardRepository.findAll();
        List<MotherboardDto> motherboardDto = motherboardList.stream()
                .map(board -> new MotherboardDto(board.getId(), board.getName(), board.getMemorySlots(), board.getFormFactor(), board.getMemoryType(),
                        board.getProducer(), board.getSocket(), board.getPrice(), board.getRemainder()))
                .collect(Collectors.toList());
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), motherboardDto.size());
        return new PageImpl<>(motherboardDto.subList(start, end), pageable, motherboardDto.size());
    }

    @Override
    public MotherboardDto getMotherboard(UUID id) {
        Motherboard board = motherboardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException("There is not such element in database"));

        return new MotherboardDto(board.getId(), board.getName(), board.getMemorySlots(), board.getFormFactor(), board.getMemoryType(),
                board.getProducer(), board.getSocket(), board.getPrice(), board.getRemainder());
    }

    @Override
    public MotherboardDto updateMotherboard(UUID id, NewMotherboardDto newBoard) {
        Motherboard motherboard = motherboardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException("There is not such element in database"));

        motherboard.setSocket(newBoard.getSocket());
        motherboard.setProducer(newBoard.getProducer());
        motherboard.setFormFactor(newBoard.getFormFactor());
        motherboard.setMemorySlots(newBoard.getMemorySlots());
        motherboard.setMemoryType(newBoard.getMemoryType());

        Motherboard updatedBoard = motherboardRepository.save(motherboard);
        return new MotherboardDto(updatedBoard.getId(), updatedBoard.getName(), updatedBoard.getMemorySlots(), updatedBoard.getFormFactor(), updatedBoard.getMemoryType(),
                updatedBoard.getProducer(), updatedBoard.getSocket(), updatedBoard.getPrice(), updatedBoard.getRemainder());
    }

    @Override
    public boolean deleteMotherboard(UUID id) {
        if(!motherboardRepository.existsById(id)) {
            throw new DBNotFoundException("There is not such element in database");
        }
        productRepository.deleteByMotherboard_Id(id);
        return true;
    }

    @Override
    public MotherboardDto saveMotherboard(NewMotherboardDto newBoard) {
        Motherboard newMotherboard = new Motherboard(newBoard.getName(), newBoard.getMemorySlots(), newBoard.getSocket(), newBoard.getFormFactor(),
                newBoard.getMemoryType(), newBoard.getProducer(), newBoard.getPrice(), newBoard.getRemainder());
        Motherboard motherboard = motherboardRepository.save(newMotherboard);
        Product product = new Product(newMotherboard, null, null, null, null);
        productRepository.save(product);
        return new MotherboardDto(motherboard.getId(), motherboard.getName(), motherboard.getMemorySlots(), motherboard.getFormFactor(), motherboard.getMemoryType(),
                motherboard.getProducer(), motherboard.getSocket(), motherboard.getPrice(), motherboard.getRemainder());
    }
}

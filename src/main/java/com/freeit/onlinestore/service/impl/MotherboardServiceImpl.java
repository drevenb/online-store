package com.freeit.onlinestore.service.impl;

import com.freeit.onlinestore.dto.req.NewMotherboardDto;
import com.freeit.onlinestore.dto.resp.MotherboardDto;
import com.freeit.onlinestore.entity.Motherboard;
import com.freeit.onlinestore.exception.DBNotFoundException;
import com.freeit.onlinestore.repository.MotherboardRepository;
import com.freeit.onlinestore.service.MotherboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public PageImpl getAllMotherboards(Pageable pageable) {
        List<Motherboard> motherboardList = motherboardRepository.findAll();
        List<MotherboardDto> motherboardDto = motherboardList.stream()
                .map(board -> new MotherboardDto(board.getId(), board.getMemorySlots(), board.getFormFactor(), board.getMemoryType(),
                        board.getMotherboardProducer(), board.getSocket(), board.getPrice(), board.getRemainder()))
                .collect(Collectors.toList());
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), motherboardDto.size());
        return new PageImpl<>(motherboardDto.subList(start, end), pageable, motherboardDto.size());
    }

    @Override
    public MotherboardDto getMotherboard(Long id) {
        Motherboard board = motherboardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException("There is not such element in database"));

        return new MotherboardDto(board.getId(), board.getMemorySlots(), board.getFormFactor(), board.getMemoryType(),
                board.getMotherboardProducer(), board.getSocket(), board.getPrice(), board.getRemainder());
    }

    @Override
    public MotherboardDto updateMotherboard(Long id, NewMotherboardDto newBoard) {
        Motherboard motherboard = motherboardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException("There is not such element in database"));

        motherboard.setSocket(newBoard.getSocket());
        motherboard.setMotherboardProducer(newBoard.getMotherboardProducer());
        motherboard.setFormFactor(newBoard.getFormFactor());
        motherboard.setMemorySlots(newBoard.getMemorySlots());
        motherboard.setMemoryType(newBoard.getMemoryType());

        Motherboard updatedBoard = motherboardRepository.save(motherboard);
        return new MotherboardDto(updatedBoard.getId(), updatedBoard.getMemorySlots(), updatedBoard.getFormFactor(), updatedBoard.getMemoryType(),
                updatedBoard.getMotherboardProducer(), updatedBoard.getSocket(), updatedBoard.getPrice(), updatedBoard.getRemainder());
    }

    @Override
    public boolean deleteMotherboard(Long id) {
        if(!motherboardRepository.existsById(id)) {
            return false;
        }
        motherboardRepository.deleteById(id);
        return true;
    }

    @Override
    public MotherboardDto saveMotherboard(NewMotherboardDto newBoard) {
        Motherboard newMotherboard = new Motherboard(newBoard.getMemorySlots(), newBoard.getSocket(), newBoard.getFormFactor(),
                newBoard.getMemoryType(), newBoard.getMotherboardProducer(), newBoard.getPrice(), newBoard.getRemainder());
        Motherboard motherboard = motherboardRepository.save(newMotherboard);
        return new MotherboardDto(motherboard.getId(), motherboard.getMemorySlots(), motherboard.getFormFactor(), motherboard.getMemoryType(),
                motherboard.getMotherboardProducer(), motherboard.getSocket(), motherboard.getPrice(), motherboard.getRemainder());
    }
}

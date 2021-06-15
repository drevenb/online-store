package com.freeit.onlinestore.service.impl;

import com.freeit.onlinestore.dto.req.NewRamDto;
import com.freeit.onlinestore.dto.resp.RamDto;
import com.freeit.onlinestore.entity.Product;
import com.freeit.onlinestore.entity.Ram;
import com.freeit.onlinestore.exception.DBNotFoundException;
import com.freeit.onlinestore.mapper.ram.NewRamMapper;
import com.freeit.onlinestore.mapper.ram.RamMapper;
import com.freeit.onlinestore.repository.ProductRepository;
import com.freeit.onlinestore.repository.RamRepository;
import com.freeit.onlinestore.service.RamService;
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
public class RamServiceImpl implements RamService {

    private final String NOT_FOUND_MESSAGE = "There is not such element in database";

    private final RamRepository ramRepository;
    private final ProductRepository productRepository;

    private final RamMapper ramMapper;
    private final NewRamMapper newRamMapper;

    @Override
    public PageImpl getAllRams(Pageable pageable) {
        List<RamDto> ramDtoList = ramMapper.toDto(ramRepository.findAll());
        log.debug("Ram Dto List: {}", ramDtoList);
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), ramDtoList.size());
        return new PageImpl<>(ramDtoList.subList(start, end), pageable, ramDtoList.size());
    }

    @Override
    public RamDto getRam(UUID uuid) {
        Ram ram = ramRepository.findById(uuid)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        log.debug("Ram is found: {}", ram);
        return ramMapper.toDto(ram);
    }

    @Override
    public RamDto updateRam(UUID uuid, NewRamDto newRamDto) {
        Ram ram = ramRepository.findById(uuid)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        log.debug("Ram is ready to update: {}", ram);

        ram.setName(newRamDto.getName());
        ram.setMemorySize(newRamDto.getMemorySize());
        ram.setMemoryFrequency(newRamDto.getMemoryFrequency());
        ram.setLatency(newRamDto.getLatency());
        ram.setMemoryType(newRamDto.getMemoryType());
        ram.setProducer(newRamDto.getProducer());
        ram.setPrice(newRamDto.getPrice());
        ram.setRemainder(newRamDto.getRemainder());

        Ram updatedRam = ramRepository.save(ram);
        log.debug("Ram is updated: {}", updatedRam);
        return ramMapper.toDto(updatedRam);
    }

    @Override
    public boolean deleteRam(UUID uuid) {
        if(!ramRepository.existsById(uuid)) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        }
        log.debug("Ram was deleted: {}", productRepository.deleteByRam_Id(uuid));
        return true;
    }

    @Override
    public RamDto saveRam(NewRamDto newRamDto) {
        Ram ram = ramRepository.save(newRamMapper.toEntity(newRamDto));
        Product product = new Product(null, null, null, ram, null);
        productRepository.save(product);
        log.debug("Ram created: {}", product);
        return ramMapper.toDto(ram);
    }
}

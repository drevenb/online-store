package com.freeit.onlinestore.service.impl;

import com.freeit.onlinestore.dto.req.NewProcessorDto;
import com.freeit.onlinestore.dto.req.NewRamDto;
import com.freeit.onlinestore.dto.resp.ProcessorDto;
import com.freeit.onlinestore.dto.resp.RamDto;
import com.freeit.onlinestore.entity.Processor;
import com.freeit.onlinestore.entity.Product;
import com.freeit.onlinestore.entity.Ram;
import com.freeit.onlinestore.exception.DBNotFoundException;
import com.freeit.onlinestore.mapper.processor.NewProcessorMapper;
import com.freeit.onlinestore.mapper.processor.ProcessorMapper;
import com.freeit.onlinestore.repository.ProcessorRepository;
import com.freeit.onlinestore.repository.ProductRepository;
import com.freeit.onlinestore.service.ProcessorService;
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
@Transactional
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

    private final String NOT_FOUND_MESSAGE = "There is not such element in database";

    private final ProcessorRepository processorRepository;
    private final ProductRepository productRepository;

    private final ProcessorMapper processorMapper;
    private final NewProcessorMapper newProcessorMapper;

    @Override
    public PageImpl getAllProcessors(Pageable pageable) {
        List<ProcessorDto> processorDtoList = processorMapper.toDto(processorRepository.findAll());
        log.debug("Processor Dto List: {}", processorDtoList);
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), processorDtoList.size());
        return new PageImpl<>(processorDtoList.subList(start, end), pageable, processorDtoList.size());
    }

    @Override
    public ProcessorDto getProcessor(UUID uuid) {
        Processor processor = processorRepository.findById(uuid)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        log.debug("Processor is found: {}", processor);
        return processorMapper.toDto(processor);
    }

    @Override
    public ProcessorDto updateProcessor(UUID uuid, NewProcessorDto newProcessorDto) {
        Processor processor = processorRepository.findById(uuid)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        log.debug("Processor is ready to update: {}", processor);

        processor.setName(newProcessorDto.getName());
        processor.setCoresQuantity(newProcessorDto.getCoresQuantity());
        processor.setFrequency(newProcessorDto.getFrequency());
        processor.setSocket(newProcessorDto.getSocket());
        processor.setProducer(newProcessorDto.getProducer());
        processor.setPrice(newProcessorDto.getPrice());
        processor.setRemainder(newProcessorDto.getRemainder());

        Processor updatedProcessor = processorRepository.save(processor);
        log.debug("Processor is updated: {}", updatedProcessor);
        return processorMapper.toDto(updatedProcessor);
    }

    @Override
    public boolean deleteProcessor(UUID uuid) {
        if(!processorRepository.existsById(uuid)) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        }
        log.debug("Processor was deleted: {}", productRepository.deleteByProcessor_Id(uuid));
        return true;
    }

    @Override
    public ProcessorDto saveProcessor(NewProcessorDto newProcessorDto) {
        Processor processor = processorRepository.save(newProcessorMapper.toEntity(newProcessorDto));
        Product product = new Product(null, processor, null, null, null);
        productRepository.save(product);
        log.debug("Processor created: {}", product);
        return processorMapper.toDto(processor);
    }
}

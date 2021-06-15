package com.freeit.onlinestore.service;

import com.freeit.onlinestore.dto.req.NewProcessorDto;
import com.freeit.onlinestore.dto.resp.ProcessorDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProcessorService {

    Page<ProcessorDto> getAllProcessors(Pageable pageable);

    ProcessorDto getProcessor(UUID uuid);

    ProcessorDto updateProcessor(UUID uuid, NewProcessorDto processor);

    boolean deleteProcessor(UUID uuid);

    ProcessorDto saveProcessor(NewProcessorDto processor);
}

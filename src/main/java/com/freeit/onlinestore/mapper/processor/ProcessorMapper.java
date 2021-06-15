package com.freeit.onlinestore.mapper.processor;

import com.freeit.onlinestore.dto.resp.ProcessorDto;
import com.freeit.onlinestore.entity.Processor;
import com.freeit.onlinestore.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class ProcessorMapper extends AbstractMapper<Processor, ProcessorDto> {

    public ProcessorMapper() {
        super(Processor.class, ProcessorDto.class);
    }
}

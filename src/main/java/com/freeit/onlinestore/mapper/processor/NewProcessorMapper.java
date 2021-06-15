package com.freeit.onlinestore.mapper.processor;

import com.freeit.onlinestore.dto.req.NewProcessorDto;
import com.freeit.onlinestore.entity.Processor;
import com.freeit.onlinestore.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NewProcessorMapper extends AbstractMapper<Processor, NewProcessorDto> {

    public NewProcessorMapper() {
        super(Processor.class, NewProcessorDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(NewProcessorDto.class, Processor.class)
                .addMappings(m -> m.skip(Processor::setId))
                .setPostConverter(toEntityConverter());
    }
}

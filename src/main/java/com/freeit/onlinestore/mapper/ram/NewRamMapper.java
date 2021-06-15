package com.freeit.onlinestore.mapper.ram;

import com.freeit.onlinestore.dto.req.NewRamDto;
import com.freeit.onlinestore.entity.Ram;
import com.freeit.onlinestore.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NewRamMapper extends AbstractMapper<Ram, NewRamDto> {

    public NewRamMapper() {
        super(Ram.class, NewRamDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(NewRamDto.class, Ram.class)
                .addMappings(m -> m.skip(Ram::setId))
                .setPostConverter(toEntityConverter());
    }
}

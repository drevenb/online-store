package com.freeit.onlinestore.mapper.motherboard;

import com.freeit.onlinestore.dto.req.NewMotherboardDto;
import com.freeit.onlinestore.entity.Motherboard;
import com.freeit.onlinestore.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NewMotherboardMapper extends AbstractMapper<Motherboard, NewMotherboardDto> {

    public NewMotherboardMapper() {
        super(Motherboard.class, NewMotherboardDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(NewMotherboardDto.class, Motherboard.class)
                .addMappings(m -> m.skip(Motherboard::setId))
                .setPostConverter(toEntityConverter());
    }
}

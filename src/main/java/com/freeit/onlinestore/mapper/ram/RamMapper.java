package com.freeit.onlinestore.mapper.ram;

import com.freeit.onlinestore.dto.resp.RamDto;
import com.freeit.onlinestore.entity.Ram;
import com.freeit.onlinestore.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class RamMapper extends AbstractMapper<Ram, RamDto> {

    public RamMapper() {
        super(Ram.class, RamDto.class);
    }
}

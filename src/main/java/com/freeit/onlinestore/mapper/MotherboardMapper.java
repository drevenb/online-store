package com.freeit.onlinestore.mapper;

import com.freeit.onlinestore.dto.resp.MotherboardDto;
import com.freeit.onlinestore.entity.Motherboard;

import org.springframework.stereotype.Component;

@Component
public class MotherboardMapper extends AbstractMapper<Motherboard, MotherboardDto>{

    public MotherboardMapper() {
        super(Motherboard.class, MotherboardDto.class);
    }
}

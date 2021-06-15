package com.freeit.onlinestore.mapper;

import com.freeit.onlinestore.dto.resp.VideocardDto;
import com.freeit.onlinestore.entity.Videocard;
import org.springframework.stereotype.Component;

@Component
public class VideocardMapper extends AbstractMapper<Videocard, VideocardDto>{

    public VideocardMapper() {
        super(Videocard.class, VideocardDto.class);
    }
}

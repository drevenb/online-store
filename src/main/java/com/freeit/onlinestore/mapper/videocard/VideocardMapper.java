package com.freeit.onlinestore.mapper.videocard;

import com.freeit.onlinestore.dto.resp.VideocardDto;
import com.freeit.onlinestore.entity.Videocard;
import com.freeit.onlinestore.mapper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class VideocardMapper extends AbstractMapper<Videocard, VideocardDto> {

    public VideocardMapper() {
        super(Videocard.class, VideocardDto.class);
    }
}

package com.freeit.onlinestore.service;

import com.freeit.onlinestore.dto.req.NewVideocardDto;
import com.freeit.onlinestore.dto.resp.VideocardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface VideocardService {

    Page<VideocardDto> getAllVideocards(Pageable pageable);

    VideocardDto getVideocard(UUID uuid);

    VideocardDto updateVideocard(UUID uuid, NewVideocardDto videocard);

    boolean deleteVideocard(UUID uuid);

    VideocardDto saveVideocard(NewVideocardDto videocard);
}

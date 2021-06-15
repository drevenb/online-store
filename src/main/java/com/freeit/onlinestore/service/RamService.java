package com.freeit.onlinestore.service;

import com.freeit.onlinestore.dto.req.NewRamDto;
import com.freeit.onlinestore.dto.resp.RamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RamService {

    Page<RamDto> getAllRams(Pageable pageable);

    RamDto getRam(UUID uuid);

    RamDto updateRam(UUID uuid, NewRamDto ram);

    boolean deleteRam(UUID uuid);

    RamDto saveRam(NewRamDto ram);
}

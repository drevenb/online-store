package com.freeit.onlinestore.service.impl;

import com.freeit.onlinestore.dto.req.NewVideocardDto;
import com.freeit.onlinestore.dto.resp.VideocardDto;
import com.freeit.onlinestore.entity.Product;
import com.freeit.onlinestore.entity.Videocard;
import com.freeit.onlinestore.exception.DBNotFoundException;
import com.freeit.onlinestore.mapper.NewVideocardMapper;
import com.freeit.onlinestore.mapper.VideocardMapper;
import com.freeit.onlinestore.repository.ProductRepository;
import com.freeit.onlinestore.repository.VideocardRepository;
import com.freeit.onlinestore.service.VideocardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class VideocardServiceImpl implements VideocardService {

    private final String NOT_FOUND_MESSAGE = "There is not such element in database";

    private final VideocardRepository videocardRepository;
    private final ProductRepository productRepository;

    private final VideocardMapper videocardMapper;
    private final NewVideocardMapper newVideocardMapper;

    @Override
    public PageImpl getAllVideocards(Pageable pageable) {
        List<VideocardDto> videocardDtoList = videocardMapper.toDto(videocardRepository.findAll());
        final int start = (int) pageable.getOffset();
        final int end = Math.min((start + pageable.getPageSize()), videocardDtoList.size());
        return new PageImpl<>(videocardDtoList.subList(start, end), pageable, videocardDtoList.size());
    }

    @Override
    public VideocardDto getVideocard(UUID uuid) {
        Videocard videocard = videocardRepository.findById(uuid)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));
        return videocardMapper.toDto(videocard);
    }

    @Override
    public VideocardDto updateVideocard(UUID uuid, NewVideocardDto newVideocardDto) {
        Videocard videocard = videocardRepository.findById(uuid)
                .orElseThrow(() -> new DBNotFoundException(NOT_FOUND_MESSAGE));

        videocard.setName(newVideocardDto.getName());
        videocard.setMemorySize(newVideocardDto.getMemorySize());
        videocard.setMemoryBuswidth(newVideocardDto.getMemoryBuswidth());
        videocard.setMemoryFrequency(newVideocardDto.getMemoryFrequency());
        videocard.setMemoryType(newVideocardDto.getMemoryType());
        videocard.setProcessorFrequency(newVideocardDto.getProcessorFrequency());
        videocard.setProducer(newVideocardDto.getProducer());
        videocard.setPrice(newVideocardDto.getPrice());
        videocard.setRemainder(newVideocardDto.getRemainder());

        Videocard updatedVideocard = videocardRepository.save(videocard);
        return videocardMapper.toDto(updatedVideocard);
    }

    @Override
    public boolean deleteVideocard(UUID uuid) {
        if(!videocardRepository.existsById(uuid)) {
            throw new DBNotFoundException(NOT_FOUND_MESSAGE);
        }
        productRepository.deleteByVideocard_Id(uuid);
        return true;
    }

    @Override
    public VideocardDto saveVideocard(NewVideocardDto newVideocardDto) {
        Videocard videocard = videocardRepository.save(newVideocardMapper.toEntity(newVideocardDto));
        Product product = new Product(null, null, videocard, null, null);
        productRepository.save(product);
        return videocardMapper.toDto(videocard);
    }
}

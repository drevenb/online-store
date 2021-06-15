package com.freeit.onlinestore.dto.resp;

import com.freeit.onlinestore.dto.AbstractProductDto;
import com.freeit.onlinestore.model.VideoMemoryType;
import com.freeit.onlinestore.model.VideocardProducer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class VideocardDto extends AbstractProductDto {
    private UUID id;
    private Integer memorySize;
    private Integer memoryBuswidth;
    private Integer memoryFrequency;
    private Integer processorFrequency;
    private VideoMemoryType memoryType;
    private VideocardProducer producer;
}

package com.freeit.onlinestore.dto.resp;

import com.freeit.onlinestore.dto.AbstractDto;
import com.freeit.onlinestore.model.VideoMemoryType;
import com.freeit.onlinestore.model.VideocardProducer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class VideocardDto extends AbstractDto {
    private UUID id;
    private String name;
    private Integer memorySize;
    private Integer memoryBuswidth;
    private Integer memoryFrequency;
    private Integer processorFrequency;
    private VideoMemoryType memoryType;
    private VideocardProducer producer;
    private double price;
    private Integer remainder;
}

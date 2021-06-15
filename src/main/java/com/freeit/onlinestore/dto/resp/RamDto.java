package com.freeit.onlinestore.dto.resp;

import com.freeit.onlinestore.dto.AbstractDto;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.RamProducer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RamDto extends AbstractDto {
    private UUID id;
    private String name;
    private Integer memorySize;
    private Integer memoryFrequency;
    private String latency;
    private MemoryType memoryType;
    private RamProducer producer;
    private double price;
    private Integer remainder;
}

package com.freeit.onlinestore.dto.req;

import com.freeit.onlinestore.dto.AbstractDto;
import com.freeit.onlinestore.model.VideoMemoryType;
import com.freeit.onlinestore.model.VideocardProducer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewVideocardDto extends AbstractDto {
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
package com.freeit.onlinestore.dto.resp;

import com.freeit.onlinestore.dto.AbstractProductDto;
import com.freeit.onlinestore.model.FormFactor;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.MotherboardProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MotherboardDto extends AbstractProductDto {
    private UUID id;
    private Integer memorySlots;
    private FormFactor formFactor;
    private MemoryType memoryType;
    private MotherboardProducer producer;
    private Socket socket;
}

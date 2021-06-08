package com.freeit.onlinestore.dto.req;

import com.freeit.onlinestore.model.FormFactor;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.MotherboardProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewMotherboardDto {
    private Integer memorySlots;
    private FormFactor formFactor;
    private MemoryType memoryType;
    private MotherboardProducer motherboardProducer;
    private Socket socket;
    private double price;
    private Integer remainder;
}

package com.freeit.onlinestore.dto.resp;

import com.freeit.onlinestore.model.FormFactor;
import com.freeit.onlinestore.model.MemoryType;
import com.freeit.onlinestore.model.MotherboardProducer;
import com.freeit.onlinestore.model.Socket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MotherboardDto {
    private UUID id;
    private String name;
    private Integer memorySlots;
    private FormFactor formFactor;
    private MemoryType memoryType;
    private MotherboardProducer producer;
    private Socket socket;
    private double price;
    private Integer remainder;
}

package com.freeit.onlinestore.dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class AbstractProductDto extends AbstractDto{
    private String name;
    private double price;
    private Integer remainder;
}

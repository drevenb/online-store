package com.freeit.onlinestore.controllers;

import com.freeit.onlinestore.dto.MotherboardDto;
import com.freeit.onlinestore.service.MotherboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags="Controller for motherboards")
@RequestMapping("/motherboards/")
public class MotherboardController {

    private final MotherboardService motherboardService;

    @ApiOperation("Method to get a page of motherboards")
    @GetMapping
    public ResponseEntity<Page<MotherboardDto>> getMotherboards(Pageable pageable) {
        return new ResponseEntity<>(motherboardService.getAllMotherboards(pageable), HttpStatus.OK);
    }

    @ApiOperation("Method to get a motherboard by Id")
    @GetMapping("/{id}")
    public ResponseEntity<MotherboardDto> getMotherboardById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(motherboardService.getMotherboard(id), HttpStatus.OK);
    }
}

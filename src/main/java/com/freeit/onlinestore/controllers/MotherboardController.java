package com.freeit.onlinestore.controllers;

import com.freeit.onlinestore.dto.req.NewMotherboardDto;
import com.freeit.onlinestore.dto.resp.MotherboardDto;
import com.freeit.onlinestore.service.MotherboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public ResponseEntity<MotherboardDto> getMotherboardById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(motherboardService.getMotherboard(id), HttpStatus.OK);
    }

    @ApiOperation("Method to update a motherboard")
    @PutMapping("/{id}")
    public ResponseEntity<MotherboardDto> updateMotherboard(@PathVariable("id") UUID id,
                                                            @RequestBody NewMotherboardDto board) {
        return new ResponseEntity<>(motherboardService.updateMotherboard(id, board), HttpStatus.OK);
    }

    @ApiOperation("Method to delete a motherboard")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMotherboard(@PathVariable("id") UUID id) {
        if(!motherboardService.deleteMotherboard(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("Method to create a motherboard")
    @PostMapping
    public ResponseEntity<MotherboardDto> createMotherboard(@RequestBody NewMotherboardDto newBoard) {
        return new ResponseEntity<>(motherboardService.saveMotherboard(newBoard), HttpStatus.OK);
    }
}

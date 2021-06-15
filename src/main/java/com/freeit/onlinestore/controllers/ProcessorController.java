package com.freeit.onlinestore.controllers;

import com.freeit.onlinestore.dto.req.NewProcessorDto;
import com.freeit.onlinestore.dto.resp.ProcessorDto;
import com.freeit.onlinestore.service.ProcessorService;
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
@Api(tags="Controller for processors")
@RequestMapping("/processors/")
public class ProcessorController {

    private final ProcessorService processorService;

    @ApiOperation(value="Method to get all processors")
    @GetMapping
    public ResponseEntity<Page<ProcessorDto>> getRams(Pageable pageable) {
        return new ResponseEntity<>(processorService.getAllProcessors(pageable), HttpStatus.OK);
    }

    @ApiOperation(value="Method to get processor by Id")
    @GetMapping("/{id}")
    public ResponseEntity<ProcessorDto> getProcessorById(@PathVariable("id") UUID uuid) {
        return new ResponseEntity<>(processorService.getProcessor(uuid), HttpStatus.OK);
    }

    @ApiOperation(value="Method to update a processor")
    @PutMapping("/{id}")
    public ResponseEntity<ProcessorDto> updateProcessor(@PathVariable("id") UUID uuid,
                                            @RequestBody NewProcessorDto processor) {
        return new ResponseEntity<>(processorService.updateProcessor(uuid, processor), HttpStatus.OK);
    }

    @ApiOperation(value="Method to delete a processor")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProcessor(@PathVariable("id") UUID uuid) {
        if(!processorService.deleteProcessor(uuid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value="Method to create a processor")
    @PostMapping
    public ResponseEntity<ProcessorDto> createProcessor(@RequestBody NewProcessorDto processor) {
        return new ResponseEntity<>(processorService.saveProcessor(processor), HttpStatus.CREATED);
    }
}

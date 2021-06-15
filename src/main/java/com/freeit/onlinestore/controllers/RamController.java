package com.freeit.onlinestore.controllers;

import com.freeit.onlinestore.dto.req.NewRamDto;
import com.freeit.onlinestore.dto.resp.RamDto;
import com.freeit.onlinestore.service.RamService;
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
@Api(tags="Controller for rams")
@RequestMapping("/rams/")
public class RamController {

    private final RamService ramService;

    @ApiOperation(value="Method to get all rams")
    @GetMapping
    public ResponseEntity<Page<RamDto>> getRams(Pageable pageable) {
        return new ResponseEntity<>(ramService.getAllRams(pageable), HttpStatus.OK);
    }

    @ApiOperation(value="Method to get ram by Id")
    @GetMapping("/{id}")
    public ResponseEntity<RamDto> getRamById(@PathVariable("id") UUID uuid) {
        return new ResponseEntity<>(ramService.getRam(uuid), HttpStatus.OK);
    }

    @ApiOperation(value="Method to update a ram")
    @PutMapping("/{id}")
    public ResponseEntity<RamDto> updateRam(@PathVariable("id") UUID uuid,
                                                        @RequestBody NewRamDto ram) {
        return new ResponseEntity<>(ramService.updateRam(uuid, ram), HttpStatus.OK);
    }

    @ApiOperation(value="Method to delete a ram")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRam(@PathVariable("id") UUID uuid) {
        if(!ramService.deleteRam(uuid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value="Method to create a ram")
    @PostMapping
    public ResponseEntity<RamDto> createRam(@RequestBody NewRamDto ram) {
        return new ResponseEntity<>(ramService.saveRam(ram), HttpStatus.CREATED);
    }
}

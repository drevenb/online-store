package com.freeit.onlinestore.controllers;

import com.freeit.onlinestore.dto.req.NewVideocardDto;
import com.freeit.onlinestore.dto.resp.VideocardDto;
import com.freeit.onlinestore.service.VideocardService;
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
@Api(tags="Controller for videocards")
@RequestMapping("/videocards/")
public class VideocardController {

    private final VideocardService videocardService;

    @ApiOperation(value="Method to get all videocards")
    @GetMapping
    public ResponseEntity<Page<VideocardDto>> getVideocards(Pageable pageable) {
        return new ResponseEntity<>(videocardService.getAllVideocards(pageable), HttpStatus.OK);
    }

    @ApiOperation(value="Method to get videocard by Id")
    @GetMapping("/{id}")
    public ResponseEntity<VideocardDto> getVideocardById(@PathVariable("id") UUID uuid) {
        return new ResponseEntity<>(videocardService.getVideocard(uuid), HttpStatus.OK);
    }

    @ApiOperation(value="Method to update a videocard")
    @PutMapping("/{id}")
    public ResponseEntity<VideocardDto> updateVideocard(@PathVariable("id") UUID uuid,
                                                        @RequestBody NewVideocardDto videocard) {
        return new ResponseEntity<>(videocardService.updateVideocard(uuid, videocard), HttpStatus.OK);
    }

    @ApiOperation(value="Method to delete a videocard")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVideocard(@PathVariable("id") UUID uuid) {
        if(!videocardService.deleteVideocard(uuid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value="Method to create a videocard")
    @PostMapping
    public ResponseEntity<VideocardDto> createVideocard(@RequestBody NewVideocardDto videocard) {
        return new ResponseEntity<>(videocardService.saveVideocard(videocard), HttpStatus.CREATED);
    }
}

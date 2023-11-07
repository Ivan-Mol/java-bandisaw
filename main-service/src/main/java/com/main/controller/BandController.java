package com.main.controller;

import com.main.model.Band;
import com.main.service.BandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/bands")
@RequiredArgsConstructor
public class BandController {

    private final BandService bandService;

    @GetMapping("/{bandName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Band> getByName(@PathVariable String bandName){
        return bandService.getBandsByName(bandName);
    }
}

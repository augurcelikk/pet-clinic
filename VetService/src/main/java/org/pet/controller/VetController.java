package org.pet.controller;

import lombok.RequiredArgsConstructor;
import org.pet.dto.request.VetSaveRequestDto;
import org.pet.service.VetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VET)
public class VetController {
    private final VetService vetService;
    @PostMapping("/vets")
    public ResponseEntity<VetSaveRequestDto> createVet(@RequestBody VetSaveRequestDto dto){
        VetSaveRequestDto createdVet=vetService.createVet(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

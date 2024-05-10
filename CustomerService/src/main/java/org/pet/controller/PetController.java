package org.pet.controller;

import lombok.RequiredArgsConstructor;
import org.pet.service.PetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PET)
public class PetController {
    private final PetService petService;
}

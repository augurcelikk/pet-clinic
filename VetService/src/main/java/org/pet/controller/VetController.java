package org.pet.controller;

import lombok.RequiredArgsConstructor;
import org.pet.service.VetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VET)
public class VetController {
    private final VetService vetService;
}

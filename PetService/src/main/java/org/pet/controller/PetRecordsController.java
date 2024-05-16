package org.pet.controller;

import lombok.RequiredArgsConstructor;
import org.pet.service.PetRecordsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PETRECORDS)
public class PetRecordsController {
    private final PetRecordsService petRecordsService;
}

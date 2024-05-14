package org.pet.controller;

import lombok.RequiredArgsConstructor;
import org.pet.service.AppointmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(APPOINTMENT)
public class AppointmentController {
    private final AppointmentService appointmentService;
}

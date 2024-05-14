package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
}

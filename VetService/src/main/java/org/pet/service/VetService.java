package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.repository.VetRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetService {
    private final VetRepository vetRepository;
}

package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.repository.PetRecordsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetRecordsService {
    private final PetRecordsRepository petRecordsRepository;
}

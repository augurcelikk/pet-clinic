package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.dto.request.VetSaveRequestDto;
import org.pet.mapper.VetMapper;
import org.pet.repository.VetRepository;
import org.pet.repository.entity.Vet;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetService {
    private final VetRepository vetRepository;
    private final VetMapper vetMapper;

    public VetSaveRequestDto createVet(VetSaveRequestDto dto){
        Vet vet=vetMapper.toEntity(dto);
        vet=vetRepository.save(vet);
        return vetMapper.toDto(vet);
    }
}

package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.dto.request.VetSaveRequestDto;
import org.pet.manager.VetManager;
import org.pet.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final VetManager vetManager;

    public void createVet(VetSaveRequestDto dto){
        vetManager.createVet(dto);
    }
}

package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.dto.request.LoginRequestDto;
import org.pet.dto.request.VetSaveRequestDto;
import org.pet.manager.AuthManager;
import org.pet.manager.VetManager;
import org.pet.repository.AdminRepository;
import org.pet.repository.entity.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final VetManager vetManager;
    private final AuthManager authManager;


    public void createVet(VetSaveRequestDto dto){
        vetManager.createVet(dto);
    }


    public ResponseEntity<String> login(String username, String password) {
        Optional<Admin> admin=adminRepository.findOptionalByUsernameAndPassword(username,password);
        LoginRequestDto loginRequestDto= LoginRequestDto.builder()
                .password(admin.get().getPassword())
                .username(admin.get().getUsername())
                .build();
        ResponseEntity<String> response = authManager.login(loginRequestDto);
        return response;
    }
}

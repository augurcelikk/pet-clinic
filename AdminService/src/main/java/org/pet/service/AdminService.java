package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.dto.request.LoginRequestDto;
import org.pet.dto.request.VetSaveRequestDto;
import org.pet.exception.AdminManagerException;
import org.pet.exception.ErrorType;
import org.pet.manager.VetManager;
import org.pet.repository.AdminRepository;
import org.pet.repository.entity.Admin;
import org.pet.utility.JwtTokenManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final VetManager vetManager;
    private final JwtTokenManager jwtTokenManager;


    public void createVet(VetSaveRequestDto dto){
        vetManager.createVet(dto);
    }


    public String login(LoginRequestDto dto) {
        Optional<Admin> admin=adminRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (admin.isEmpty()) throw new AdminManagerException(ErrorType.ADMIN_NOT_FOUND);
        Optional<String> jwtToken = jwtTokenManager.createToken(admin.get().getId());
        if(jwtToken.isEmpty())
            throw new AdminManagerException(ErrorType.INVALID_TOKEN);
        return jwtToken.get();
    }
}

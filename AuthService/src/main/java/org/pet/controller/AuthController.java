package org.pet.controller;

import org.pet.dto.request.LoginRequestDto;
import org.pet.dto.request.RegisterRequestDto;
import org.pet.dto.response.BaseResponseDto;
import org.pet.dto.response.LoginResponseDto;
import org.pet.dto.response.RegisterResponseDto;
import org.pet.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;



    @PostMapping(REGISTER)
    @CrossOrigin("*")
    public ResponseEntity<BaseResponseDto<RegisterResponseDto>> register(@RequestBody @Valid RegisterRequestDto dto){
        authService.register(dto);
        return ResponseEntity.ok(BaseResponseDto.<RegisterResponseDto>builder()
                        .responseCode(200)
                        .data(RegisterResponseDto.builder()
                                .isRegister(true)
                                .message("Üyelik Başarı ile gerçekleşti")
                                .build())
                .build());
    }

    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody @Valid LoginRequestDto dto){
        String token = authService.login(dto);
        return ResponseEntity.ok(BaseResponseDto.<LoginResponseDto>builder()
                        .responseCode(200)
                        .data(LoginResponseDto.builder()
                                .isLogin(true)
                                .token(token)
                                .build())
                .build());
    }
}

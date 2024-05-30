package org.pet.controller;

import lombok.RequiredArgsConstructor;
import org.pet.dto.request.LoginRequestDto;
import org.pet.dto.request.VetSaveRequestDto;
import org.pet.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN)
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/vets")
    public ResponseEntity<Void> createVet(@RequestBody VetSaveRequestDto dto){
        adminService.createVet(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequest) {
        String token = String.valueOf(adminService.login(loginRequest.getUsername(), loginRequest.getPassword()));
        return ResponseEntity.ok(token);
    }
}

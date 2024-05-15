package org.pet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.pet.dto.request.CustomerSaveRequestDto;
import org.pet.repository.entity.Customer;
import org.pet.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.pet.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody @Valid CustomerSaveRequestDto dto){
        Customer customer =   customerService.save(dto);
        return ResponseEntity.ok().build();
    }
}

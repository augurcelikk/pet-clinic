package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.dto.request.CustomerSaveRequestDto;
import org.pet.repository.CustomerRepository;
import org.pet.repository.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Customer save(CustomerSaveRequestDto dto){
        Customer result = customerRepository.save(
                Customer.builder()
                        .authId(dto.getAuthId())
                        .email(dto.getUserName())
                        .build()
        );
        return result;
    }
}

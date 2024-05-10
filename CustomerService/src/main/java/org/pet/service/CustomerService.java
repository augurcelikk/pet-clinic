package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
}

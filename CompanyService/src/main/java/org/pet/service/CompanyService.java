package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
}

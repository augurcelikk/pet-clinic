package org.pet.service;

import lombok.RequiredArgsConstructor;
import org.pet.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
}

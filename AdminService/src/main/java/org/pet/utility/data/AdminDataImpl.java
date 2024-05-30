package org.pet.utility.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.pet.repository.AdminRepository;
import org.pet.repository.entity.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AdminDataImpl {
    private final AdminRepository adminRepository;

    @PostConstruct
    public void createSampleAdmin(){
        List<Admin> admins=new ArrayList<>();
        Admin admin1= Admin.builder()
                .username("admin1")
                .password("123456")
                .build();
        admins.add(admin1);
        adminRepository.saveAll(admins);
    }

}

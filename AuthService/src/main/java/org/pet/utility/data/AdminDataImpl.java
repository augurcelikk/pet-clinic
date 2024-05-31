package org.pet.utility.data;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.pet.repository.AuthRepository;
import org.pet.repository.entity.Auth;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AdminDataImpl {
    private final AuthRepository authRepository;

    @PostConstruct
    public void createSampleAdmin(){
        List<Auth> auths=new ArrayList<>();
        Auth auth1= Auth.builder()
                .username("admin1")
                .password("123456")
                .build();
        auths.add(auth1);
        authRepository.saveAll(auths);
    }

}

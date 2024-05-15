package org.pet.service;

import org.pet.dto.request.LoginRequestDto;
import org.pet.dto.request.RegisterRequestDto;
import org.pet.exception.AuthException;
import org.pet.exception.ErrorType;
import org.pet.mapper.AuthMapper;
import org.pet.repository.AuthRepository;
import org.pet.repository.entity.Auth;
import org.pet.utility.JwtTokenManager;
import org.pet.utility.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository repository;
    private final JwtTokenManager jwtTokenManager;
    public void register(RegisterRequestDto dto){
        /**
         * Yeni üye olmak için gelen userName veritabanında kayıtlı olup olmadığını
         * kontrol ediyoruz. Eğer kullanıcı kayıtlı ise hata fırlatıyoruz.
         */
        repository.findOptionalByUserName(dto.getUserName())
                .ifPresent(auth->{
                    throw new AuthException(ErrorType.KAYITLI_KULLANICI_ADI);
                });
        Auth auth = AuthMapper.INSTANCE.fromDto(dto);
        auth.setCreateAt(System.currentTimeMillis());
        auth.setUpdateAt(System.currentTimeMillis());
        auth.setState(State.AKTIF);
        repository.save(auth);
        /**
         * Kullanıcı yeni bir hesap açtığında auth bilgileri kayıt oluyor. Ancak kullanıcı uygulama içinde
         * UserProfile bilgisi ile hareket edecek. Bu nedenle register işleminde kullanıcının profil bilgilerininde
         * oluşturulması gerekli.
         */
//        userProfileManager.save(UserProfileSaveRequestDto.builder()
//                        .authId(auth.getId())
//                        .userName(auth.getUserName())
//                .build());
       // userProfileManager.save(AuthMapper.INSTANCE.fromAuth(auth));

    }

    public String login(LoginRequestDto dto){
        Optional<Auth> auth = repository.findOptionalByUserNameAndPassword(dto.getUserName(),dto.getPassword());
        if(auth.isEmpty()) throw new AuthException(ErrorType.USERNAME_PASSWORD_ERROR);
        /**
         * Kullanıcının authId bilgisi ile token üretiyoruz. Bu token bilgisini döneceğiz.
         */
        Optional<String> jwtToken = jwtTokenManager.createToken(auth.get().getId());
        if(jwtToken.isEmpty())
            throw new AuthException(ErrorType.TOKEN_ERROR);
        return jwtToken.get();
    }
}

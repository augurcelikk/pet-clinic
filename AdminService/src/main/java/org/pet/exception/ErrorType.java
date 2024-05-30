package org.pet.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(5200,"Sunucu Hatasi...", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4200,"Parametre Hatasi...", HttpStatus.BAD_REQUEST),
    ADMIN_DUPLICATE(4210,"Admin adi kullanilmaktadir" ,HttpStatus.BAD_REQUEST),
    ADMIN_NOT_FOUND(4211,"Admin bulunamadi..." , HttpStatus.BAD_REQUEST ),
    ADMIN_NOT_CREATED(4212,"Admin profili olusturulamadi...",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4213,"Gecersiz token",HttpStatus.BAD_REQUEST)
    ;
    private int code;
    private String message;
    private HttpStatus httpStatus;
}

package org.pet.exception;

import lombok.Getter;



@Getter
public class AdminManagerException extends RuntimeException{

    private final ErrorType errorType;

    public AdminManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType = errorType;
    }
    public AdminManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}

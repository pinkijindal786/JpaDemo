package com.employee.jpademo.JpaExeptionHandler;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public static final long serialVersionUID = 1L; //L=long

    public ResourceNotFoundException(String s) {
        super (s);
    }
}

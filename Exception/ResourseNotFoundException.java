package com.biggrin.employee_management_system.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends  Exception{
    public ResourseNotFoundException(String massage){

    }
}

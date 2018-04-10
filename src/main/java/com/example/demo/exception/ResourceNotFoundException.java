package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
@Getter
@EqualsAndHashCode(callSuper = false)
public class ResourceNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = -1493212227491504123L;
	private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
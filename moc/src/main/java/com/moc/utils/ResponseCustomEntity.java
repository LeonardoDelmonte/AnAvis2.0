package com.moc.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * ResponseEntity
 * 
 * @param <T>
 * 
 * @param <T>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ResponseCustomEntity<T> extends ApiResponse {

    private T entity;

    public ResponseCustomEntity(T entity){
        this.entity = entity;
    }

}

    

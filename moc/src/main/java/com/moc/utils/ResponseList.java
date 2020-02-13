package com.moc.utils;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * ResponseList
 * 
 * @param <T>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ResponseList<T> extends ApiResponse {

    private List<T> list;

    public ResponseList(List<T> list) {
        this.list=list;
        this.setMessage("ok");
        this.setHttpStatus(HttpStatus.OK);
    }
    
}
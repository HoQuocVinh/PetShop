package com.hcmute.vinh19110318.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by: IntelliJ IDEA
 *
 * @author : ThanhTrong
 * @mailto : ntt.thanhtrong@gmail.com
 * @created : 5/15/2023, Monday
 * @filename : ApiResponse
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private T result;
    private String message;
}

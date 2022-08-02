package com.cgi.banking.bankingapi.Payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class ApiResponse {
    private Integer status;
    private Object data;
    private Object error;

    public ApiResponse(Integer status, Object data, Object error) {
        this.status = 200;
        this.data = data;
        this.error = error;
    }

    

    
}

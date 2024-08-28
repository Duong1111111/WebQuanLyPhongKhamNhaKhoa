package com.crud.dental.model;

import lombok.Data;

@Data
public class ServiceResponse {
    Boolean success;
    String message;
    private Object data;    // Dữ liệu liên quan (nếu có)
}

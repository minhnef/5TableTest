package com.example.demo.entity.respon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Respon<T> {
    private int status;
    private String error;
    private T data;
}

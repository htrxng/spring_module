package com.codegym.model;

import lombok.Data;

@Data
public class Counter {
    private int count;

    public int increment() {
        return count++;
    }
}

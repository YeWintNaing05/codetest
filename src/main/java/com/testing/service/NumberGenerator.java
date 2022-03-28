package com.testing.service;

import java.util.Random;

public class NumberGenerator implements Generator {


    private static final int LEFT_LIMIT = 0;
    private static final int RIGHT_LIMIT = 9;


    private final int length;

    public NumberGenerator(int length) {
        this.length = length;
    }


    @Override
    public String generate() {
        Random random = new Random();

        return random.ints(LEFT_LIMIT, RIGHT_LIMIT + 1).limit(length).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

    }
}

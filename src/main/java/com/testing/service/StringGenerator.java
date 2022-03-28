package com.testing.service;

import java.util.Random;

public class StringGenerator implements Generator {

    private static final int LEFT_LIMIT = 97; // letter 'a'
    private static final int RIGHT_LIMIT = 122; // letter 'z'

    private final int length;

    public StringGenerator(int length) {
        this.length = length;
    }


    @Override
    public String generate() {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = LEFT_LIMIT + (int)
                    (random.nextFloat() * (RIGHT_LIMIT - LEFT_LIMIT + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();

    }
}

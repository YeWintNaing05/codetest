package com.testing.service;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class FileServiceImpl implements FileService {

    private final Generator generator;

    public FileServiceImpl(Generator generator) {
        this.generator = generator;
    }


    @Override
    public void createFile(String fullPath, int numberOfLine) throws IOException {

        if (fullPath == null || fullPath.trim().equals("") || fullPath.isEmpty()) {
            throw new IllegalArgumentException("fullPath is empty!");
        }


        if (!(numberOfLine >= 1 && numberOfLine <= 229)) {
            throw new IllegalArgumentException("Invalid Number!");
        }

        try (FileOutputStream fos = new FileOutputStream(fullPath)) {
            StringBuilder stringBuffer = new StringBuilder(numberOfLine);

            stringBuffer.append(this.generator.generate());

            for (int i = 1; i < numberOfLine; i++) {
                stringBuffer.append("\n");
                stringBuffer.append(this.generator.generate());
            }

            String value = stringBuffer.toString();


            fos.write(value.getBytes(StandardCharsets.UTF_8));
        }


    }


}

package com.testing.service;


import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileServiceImplTest {

    @Test
    public void testCreateFile() throws IOException {

        FileService fileService = new FileServiceImpl(new StringGenerator(100));

        fileService.createFile("src\\test\\resource\\fileToCreate2.txt", 229);

        File file = new File("src\\test\\resource\\fileToCreate.txt");

        assert (file.exists());


        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        int count = 0;
        while (br.readLine() != null) {
            count++;
        }

        fr.close();

        assert (count == 233);


    }

    @Test
    public void testExceptionThrown_thenAssertionSucceeds() throws IOException {
        FileService fileService = new FileServiceImpl(new StringGenerator(100));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            fileService.createFile("src\\test\\resource\\fileToCreate2.txt", -1);

        });

        String expectedMessage = "Invalid Number!";

        Assert.assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    public void testExceptionThrownForFileName_thenAssertionSucceeds() throws IOException {
        FileService fileService = new FileServiceImpl(new StringGenerator(100));

        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            fileService.createFile(null, 2);

        });

        String expectedMessage = "fullPath is empty!";

        Assert.assertEquals(expectedMessage, exception.getMessage());

    }


}
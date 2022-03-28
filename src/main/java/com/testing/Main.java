package com.testing;

import com.testing.service.FileService;
import com.testing.service.FileServiceImpl;
import com.testing.service.StringGenerator;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        System.out.println("Please enter the x value.");
        Scanner scanner = new Scanner(System.in);

        int x =  scanner.nextInt();

        System.out.println("Please enter the file name to save in resource folder!");
        String fileName = scanner.next();

        FileService fileService = new FileServiceImpl(new StringGenerator(100));

        fileService.createFile("src\\main\\resource\\" + fileName+ ".txt", x);

        System.out.println("Successfully created!");

    }
}

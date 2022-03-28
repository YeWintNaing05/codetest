package com.testing.service;

import java.io.File;
import java.io.IOException;

public interface FileService {

    void createFile(String fullPath, int numberOfLine) throws IOException;

}

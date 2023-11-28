package com.example.Leetcode.Resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataLoader {
    public static String loadCodeFromFile(String fileName) throws IOException {
        // Use ClassPathResource to load the file from the classpath
        Resource resource = new ClassPathResource(fileName);

        try (InputStream inputStream = resource.getInputStream()) {
            // Read the file content from the InputStream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder codeBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                codeBuilder.append(line).append("\n");
            }
            return codeBuilder.toString();
        }
    }
}

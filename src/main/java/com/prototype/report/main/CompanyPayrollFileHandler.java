package com.prototype.report.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CompanyPayrollFileHandler {
    public static void write(String data, String path){
        try {
            Path file = Paths.get(path);
            byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
            Files.write(file, dataBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String path){
        Path file = Paths.get(path);
        byte[] dataBytes = null;
        try {
            dataBytes = Files.readAllBytes(file);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        assert dataBytes != null;
        return new String(dataBytes, StandardCharsets.UTF_8);
    }
}

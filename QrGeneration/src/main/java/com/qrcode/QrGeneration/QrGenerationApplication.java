package com.qrcode.QrGeneration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.*;

@SpringBootApplication
public class QrGenerationApplication  {

    public static void main(String[] args) {
        SpringApplication.run(QrGenerationApplication.class, args);
    }

}

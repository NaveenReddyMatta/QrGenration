package com.qrcode.QrGeneration.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import com.qrcode.QrGeneration.model.QRCodeEntity;
import com.qrcode.QrGeneration.repository.QRCodeRepository;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeService {

    private final QRCodeRepository qrCodeRepository;

    public QRCodeService(QRCodeRepository qrCodeRepository) {
        this.qrCodeRepository = qrCodeRepository;
    }

    public String generateQRCode(String data) {
        try {
            // Generate unique filename
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String fileName = "qrcode_" + timestamp + ".png"; 
            
            // Use the "static" folder within the project for saving QR codes
            String folderPath = "src/main/resources/static/qrcodes";  // Ensure it's inside resources
            Path directory = Paths.get(folderPath);
            
            // Create directory if not exists
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            Path filePath = directory.resolve(fileName);
            int width = 300;
            int height = 300;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);

            // Write QR code image to the file
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", filePath);

            // Save data in the database with the relative path
            QRCodeEntity qrCode = new QRCodeEntity();
            qrCode.setData(data);
            qrCode.setQrCodePath("qrcodes/" + fileName); // Save relative path to serve it from static folder
            qrCodeRepository.save(qrCode);

            return "qrcodes/"+fileName;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return "Error generating QR Code";
        }
    }

    }

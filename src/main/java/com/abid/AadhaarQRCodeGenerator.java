package com.abid;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class AadhaarQRCodeGenerator implements QRCodeGenerator {

    // Method to generate a QR Code image from the given content
    @Override
    public void generateQRCode(String content, int width, int height, String filePath)  {

        // QRCodeWriter is a class from ZXing that generates QR code matrices
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        // Encode the text into a BitMatrix
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }

        // Define where to store the image
        Path path = FileSystems.getDefault().getPath(filePath);

        // Save the image to the given path as PNG
        try {
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("✅ QR Code generated successfully at: " + filePath);
    }

}

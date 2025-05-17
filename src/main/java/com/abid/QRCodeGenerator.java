package com.abid;

public interface QRCodeGenerator {
    void generateQRCode(String content, int width, int height, String filePath);
}

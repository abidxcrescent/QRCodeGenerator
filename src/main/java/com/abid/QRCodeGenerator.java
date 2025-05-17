package com.abid;

public interface QRCodeGenerator {
    /*
     todo instead of taking content as string take is an Object.
     Object should be dynamic, using dynamic object.
     */
    void generateQRCode(String content, int width, int height, String filePath);
}

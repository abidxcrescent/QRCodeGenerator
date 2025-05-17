package com.abid;

import java.util.Scanner;
public class App{
    public static void main(String[] args) {
        // Accept user input from console
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Gender (Male/Female/Other): ");
        String gender = scanner.nextLine();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        System.out.print("Enter Aadhaar Number (12 digits): ");
        String aadhaarNumber = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        // Combine the user info into a formatted string
        String qrContent = String.format(
                "Name: %s\nGender: %s\nDOB: %s\nAadhaar No: %s\nAddress: %s",
                name, gender, dob, aadhaarNumber, address
        );

        // File path and dimensions of the QR code
        String filePath = "aadhaar_qr.png";
        int width = 300;
        int height = 300;

        QRCodeGenerator qrCodeGenerator = new AadhaarQRCodeGenerator();

        try {
            qrCodeGenerator.generateQRCode(qrContent, width, height, filePath);
        } catch (Exception e) {
            System.err.println("❌ Error generating QR Code: " + e.getMessage());
        }

        scanner.close();
    }
}
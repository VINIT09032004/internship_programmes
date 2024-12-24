package internship_programmes;

import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt text using Caesar Cipher
    public static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        shift = shift % 26; // Ensure the shift stays within alphabet range

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) ((ch - base + shift) % 26 + base);
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(ch); // Keep non-letters unchanged
            }
        }
        return encrypted.toString();
    }

    // Method to decrypt text using Caesar Cipher
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26)); // Decrypt by reversing the shift
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caesar Cipher Encryptor/Decryptor");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the shift value: ");
        int shift = scanner.nextInt();

        switch (choice) {
            case 1:
                String encryptedText = encrypt(text, shift);
                System.out.println("Encrypted Text: " + encryptedText);
                break;

            case 2:
                String decryptedText = decrypt(text, shift);
                System.out.println("Decrypted Text: " + decryptedText);
                break;

            default:
                System.out.println("Invalid choice. Please run the program again.");
        }

        scanner.close();
    }
}

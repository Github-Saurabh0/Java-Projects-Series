import java.io.*;
import java.util.Scanner;

public class FileEncryptor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🔐 File Encryption & Decryption System");
        System.out.print("📄 Enter file path to encrypt/decrypt: ");
        String filePath = sc.nextLine();
        System.out.print("🔑 Enter secret key (0-255): ");
        int key = sc.nextInt();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();

            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) (data[i] ^ key); // XOR logic for reversible encryption
            }

            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(data);
            fos.close();

            System.out.println("✅ Operation completed. File encrypted/decrypted successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

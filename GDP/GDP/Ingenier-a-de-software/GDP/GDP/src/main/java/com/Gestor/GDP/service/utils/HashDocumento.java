import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashDocumento {

    public static String calcularHash(String rutaArchivo) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[8192];
        int bytesRead;

        try (FileInputStream fis = new FileInputStream(rutaArchivo)) {
            while ((bytesRead = fis.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }
        }

        byte[] hashBytes = digest.digest();
        StringBuilder sb = new StringBuilder(hashBytes.length * 2);
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ruta = null;
        if (args.length > 0) {
            ruta = args[0];
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa la ruta completa del archivo: ");
            ruta = sc.nextLine().trim();
            sc.close();
        }

        try {
            String hash = calcularHash(ruta);
            System.out.println("SHA-256: " + hash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error: SHA-256 no está disponible en este entorno.");
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo. Verifica la ruta: " + ruta);
        }
    }
}

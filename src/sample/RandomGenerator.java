package sample;
import java.util.Random;

public class RandomGenerator {

    public static String generateTypeOne(){
        Random r = new Random();
        String alphabet = "abc0d1e2f3g4h5i6j7k8l9m0n1o2p3q4r5s6t7u8v9w0xyz";
        String cadena = "";
        for (int i = 0; i < 6; i++) {
            cadena = cadena + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return cadena;
    }

    public static String generateTypeTwo(){
        Random r = new Random();
        String alphabet = "0123456789";
        String cadena = "";
        for (int i = 0; i < 6; i++) {
            cadena = cadena + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return cadena;
    }
}

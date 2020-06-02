package sample;
import java.util.Random;

public class RandomGenerator {

    public static String randomGeneration(){
        Random r = new Random();
        String alphabet = "0a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0uvwxyz";
        String cadena = "";
        for (int i = 0; i < 6; i++) {
            cadena = cadena + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return cadena;
    }
}

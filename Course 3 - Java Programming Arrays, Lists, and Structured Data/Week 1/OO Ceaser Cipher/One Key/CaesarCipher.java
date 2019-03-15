
/**
 * Write these methods in a CaesarCipher class you can use in the next lesson.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * @date 11 March, 19
 */
import edu.duke.*;
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    int newKey;
    // Call the Constructor
    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIKJKLMNOPQRTSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        newKey = key;
    }
    
    public String encrypt(String input){
        caesarCipherFirst ccF = new caesarCipherFirst();
        return ccF.encrypt(input, newKey);
    }
    
    public String decrypt(String input){
        CaesarBreaker cb = new CaesarBreaker();
        return cb.decrypt(input, newKey);
    }
}

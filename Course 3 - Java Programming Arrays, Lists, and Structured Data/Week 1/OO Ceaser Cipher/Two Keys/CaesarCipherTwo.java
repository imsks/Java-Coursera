
/**
 * In this assignment, you will put together the CaesarCipherTwo class 
 * that encrypts a message with two keys (the same way as the previous 
 * lesson: key1 is used to encrypt every other letter, starting with 
 * the first, and key2 is used to encrypt every other letter, starting 
 * with the second), and also decrypts the same message. In addition you 
 * will create a second class, TestCaesarCipherTwo to test examples that 
 * use the CaesarCipherTwo class, including writing a method that will 
 * automatically decrypt an encrypted file by determining the two keys 
 * that were used to encrypt it.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * @date 14 Mar 19
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    int newKey1, newKey2;
    // Call the Constructor
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIKJKLMNOPQRTSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        newKey1 = key1;
        newKey2 = key2;
    }
    
    public String encrypt(String input){
        caesarCipherFirst ccF = new caesarCipherFirst();
        return ccF.encryptTwoKeys(input, newKey1, newKey2);
    }
    
    public String decrypt(String input){
        CaesarBreaker cb = new CaesarBreaker();
        return cb.decrypt(input, newKey1, newKey2);
    }
}

import edu.duke.*;
public class TestCaesarCipherTwo {
    CaesarBreaker cb = new CaesarBreaker();
    //String halfOfString = cb.halfOfString();
    //int[] countLetters = cb.countLetters();
    //int maxIndex = cb.maxIndex();
    int key1 = 17;
    int key2 = 3;
    CaesarCipherTwo cc2 = new CaesarCipherTwo(key1, key2);
    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = cc2.encrypt(message);
        String decrypted = cc2.decrypt(message);
        System.out.println("The encrypted string is " + encrypted + " with key " + key1 + " and " + key2);
        System.out.println("The decrypted string is " + breakCaesarCipher(encrypted));
    }
    
    public String breakCaesarCipher(String input){
        return cb.decryptTwoKeys(input);
    }
}

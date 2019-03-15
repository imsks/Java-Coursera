import edu.duke.*;
public class TestCaesarCipher {
    int key = 18;
    // Calling from CeaserBreaker
    CaesarBreaker cb = new CaesarBreaker();
    CaesarCipher cc = new CaesarCipher(key);
    public void simpleTests(){
        FileResource fr = new FileResource("msg1.txt");
        String message = fr.asString();
        String encryptedMessage = cc.encrypt(message);
        String decryptedMessage = cc.decrypt(message);
        System.out.println("The encrypted String is " + encryptedMessage + " with key " + key);
        //System.out.println("The encrypted String is " + decryptedMessage);
        System.out.println("The decrypted String is " + breakCaesarCipher(encryptedMessage));
    }
    
    public String breakCaesarCipher(String input){
        int key = cb.getKey(input);
        return cc.decrypt(input);
    }
}

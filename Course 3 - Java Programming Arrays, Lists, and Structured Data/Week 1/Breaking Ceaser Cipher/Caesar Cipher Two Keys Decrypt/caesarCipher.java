
/**
 * Write these methods in a CaesarCipher class you can use in the next lesson.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * @date 11 March, 19
 * shhsd
 */
import edu.duke.*;
public class caesarCipher {
    public String encrypt(String input, int key){
        StringBuilder newStr = new StringBuilder(input);
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = alphabetUpper.toLowerCase();
        
        String newAlphabetUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0, key);
        String newAlphabetLower = alphabetLower.substring(key) + alphabetLower.substring(0, key);
        
        for(int i = 0; i < newStr.length(); i++){
            char currChar = newStr.charAt(i);
            if(Character.isUpperCase(currChar)){
                int indexUpper = alphabetUpper.indexOf(currChar);
                if(indexUpper != -1){
                    char newCharUpper = newAlphabetUpper.charAt(indexUpper);
                    newStr.setCharAt(i, newCharUpper);
                }
            }
            if(Character.isLowerCase(currChar)){
                int indexLower = alphabetLower.indexOf(currChar);
                if(indexLower != -1){
                    char newCharLower = newAlphabetLower.charAt(indexLower);
                    newStr.setCharAt(i, newCharLower);
                }
            }
        }
        return newStr.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
         //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf( Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            if(idx != -1 && i%2 ==0){
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            else if (idx != -1 && i%2 ==1){
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }

    
    public void tester(){
        
        //FileResource fr = new FileResource("msg1.txt");
        //String message = fr.asString();
        /*
        int key = 15;
        String encrypted = encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", key);
        System.out.println("The key is : " + key + " and the message is " + encrypted);
        */
        
        
        int key1 = 21;
        int key2 = 8;
        String encryptTwoKeys = encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", key1, key2);
        System.out.println("The first key is : " + key1 + "The second key is : " + key2 + " and the message is " + encryptTwoKeys);
        
    }
}

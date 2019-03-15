
/**
 * You will write a program to transform words from a file into another form, 
 * such as replacing vowels with an asterix.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * date 11 March, 2019
 */
import edu.duke.*;
public class wordPlay {
    
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'){
            return true;
        }
        return false;
    }
    
   
    public String replaceVowels(String phrase, char ch){
        StringBuilder newStr = new StringBuilder(phrase);
        for(int i = 0; i < newStr.length(); i++){
            char currChar = newStr.charAt(i);
            if(isVowel(currChar)){
                newStr.setCharAt(i, ch);
            }
        }
        
        return newStr.toString();
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder newStr = new StringBuilder(phrase);
        for(int i = 0; i < newStr.length(); i++){
            char currChar = newStr.charAt(i);
            if(currChar == ch){
                int j = newStr.toString().indexOf(currChar);
                if(j % 2 == 0){
                    newStr.setCharAt(i,'*');
                }
                else{
                    newStr.setCharAt(i,'+');
                }
            }
        }
        return newStr.toString();
    }
   
    public void tester(){
        // For isVowel()
        //System.out.println(isVowel('o'));
        
        // For replaceVowels()
        //String result = replaceVowels("Brad Pitt", '*');
        //System.out.println(result);
        
        // For emphasize()
        String result = emphasize("dna ctgaaactga", 'a');
        System.out.println(result);
    }
}


/**
 * You will write a program to figure out the most common word length of 
 * words from a file. To solve this problem you will need to keep track of 
 * how many words from a file are of each possible length. You should group 
 * all words of length 30 or more together, and you should not count basic 
 * punctuation that are the first or last characters of a group of characters.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * @date 13 Mar, 19
 */
import edu.duke.*;
public class wordLengths {
    public int[] countWordLengths(FileResource fr, int[] counter){
        for(String s : fr.words()){
            int n = s.length();
            int len = 0;
            for(int i = 0; i < n; i++){
                if(Character.isLetter(s.charAt(i))){
                    len += 1;
                }
            }
            if(len <= counter.length && len != 0){
                counter[len - 1] += 1;
            }
        }
        return counter;
    }
    
    public int indexOfMax(int[] val){
        int max = 0;
        for(int k = 0; k < val.length; k++){
            if(val[k] > max){
                max = val[k];
            }
        }
        return max;
    }
    
    public void testCountWordLengths(){
        FileResource fr = new FileResource("msg1.txt");
        int[] count = new int[31];
        int[] result = countWordLengths(fr, count);
        int max = indexOfMax(result);
        for(int k = 0; k < count.length; k++){
            System.out.println(result[k] + " words of length " + (k + 1) + " with max length is " + max);
        }
    }
}

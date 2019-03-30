
/**
 * You will write a program to determine the word that occurs the most often 
 * in a file. If more than one word occurs as the most often, then return the 
 * first such word found. You should make all words lowercase before counting 
 * them. Thus, “This” and “this” will both be counted as the lowercase version 
 * of “this”. You should not consider punctuation, so “end” and “end,” will be 
 * considered different words. Use the WordFrequencies program in the lesson as 
 * a starting point.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * @date 21 March, 19
 */
import edu.duke.*;
import java.util.ArrayList;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    private void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource("errors.txt");
        
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }
    
    private int findIndexOfMax(ArrayList myWords){
        int max = 0;
        for(int k = 0; k < myWords.size(); k++){
            if(max < myFreqs.get(k)){
                max = myFreqs.get(k);
            }
        }
        return max;
    }
    
    private void mostOften(ArrayList myWords){
        int max = findIndexOfMax(myWords);
        for(int k = 0; k< myFreqs.size(); k++){
            if(max == myFreqs.get(k)){
                System.out.println(myWords.get(k));
            }
        }
    }
    
    
    public void tester(){
        findUnique();
        System.out.println("Unique words are " + myWords.size());
        for(int k = 0; k< myWords.size(); k++){
            System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        }
        System.out.println("Max value is " + findIndexOfMax(myWords));
        mostOften(myWords);
    }
}

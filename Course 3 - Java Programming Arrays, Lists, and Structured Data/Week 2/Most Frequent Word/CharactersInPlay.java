
/**
 * Write a program to print out the main characters in one of Shakespeare’s 
 * plays, those with the most speaking parts. You should identify a speaking 
 * part by reading the file line-by-line and finding the location of the first 
 * period on the line. Then you will assume that everything up to the first 
 * period is the name of a character and count how many times that occurs in 
 * the file. You will only print those characters that appear more often than 
 * others. Notice our method is somewhat error prone. For example, a period is 
 * also used to indicate the end of a sentence. By printing out only those 
 * characters that appear a lot, we will get rid of most of the errors. 
 * Periods that indicate the end of a sentence will likely be a unique phrase 
 * so you won’t print that as it would just occur once or maybe twice.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * @date 21 Mar 19
 */
import edu.duke.*;
import java.util.ArrayList;
public class CharactersInPlay {
    private ArrayList<String> name;
    private ArrayList<Integer> counts;
    
    public CharactersInPlay(){
        name = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    private void update(String person){
        person = person.trim();
        int index = name.indexOf(person);
        if(index == -1){
            name.add(person);
            counts.add(1);
        }
        else{
            int val = counts.get(index);
            counts.set(index, val + 1);
        }
    }
    
    private void findAllCharacters(){
        FileResource fr = new FileResource("test.txt");
        for(String s : fr.lines()){
            int index = s.indexOf('.');
            if(index != -1){
                s = s.substring(0, index);
                update(s);
            }
        }
    }
    
    private void charactersWithNumParts(int num1, int num2){
        int i;
        for(i = 0; i < counts.size(); i++){
            if(counts.get(i) >= num1 && counts.get(i) <= num2){
                System.out.println(counts.get(i) + "\t" + name.get(i));
            }
        }
    }
    
    public int max(ArrayList name){
        int max = 0;
        for(int k = 0; k < counts.size(); k++){
            if(max < counts.get(k)){
                max = counts.get(k);
            }
        }
        return max;
    }
    
    public void mostChar(ArrayList name){
        int max = max(name);
        for(int k = 0; k < counts.size(); k++){
            if(max == counts.get(k)){
                System.out.println(name.get(k) + "\t" + counts.get(k));
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        for(int k = 0; k < name.size(); k++){
          //System.out.println(name.get(k) + " has " + counts.get(k) + " no of dialouges ");
          
        }
        //mostChar(name);
        charactersWithNumParts(10,15);
    }
}

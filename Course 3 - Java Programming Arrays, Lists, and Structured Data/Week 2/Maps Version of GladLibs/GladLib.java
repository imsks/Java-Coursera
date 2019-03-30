
/**
 * Start with your GladLibs program you completed earlier in this lesson. 
 * Make a copy of it and call it GladLibMap.java. Now modify this program 
 * to use one HashMap that maps word types to ArrayList of possible words 
 * to select. Your program should still work for the additional categories 
 * verbs and fruits and should not use duplicate words from a category. 
 * Specifically, you should make the following adjustments to this program:
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (1.0)
 * Date - 24 March 19
 */

import edu.duke.*;
import java.util.*;

public class GladLib {
    private HashMap<String, ArrayList<String>> myMap;
    private ArrayList<String> used;
    private ArrayList<String> usedcategory;
    
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private ArrayList<String> trackList;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLib(){
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLib(String source){
        initializeFromSource(source);
        myRandom = new Random();
        myMap = new HashMap<String, ArrayList<String>>();
    }
    
    private void initializeFromSource(String source) {
        ArrayList<String> arrList = new ArrayList<String>();
        String[] category = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
        for(int k = 0; k < category.length; k++){
            arrList = readIt(source + "/" + category[k] + ".txt");
            myMap.put(category[k], arrList);
        }
        used = new ArrayList<String>();
        usedcategory = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        String ret = "";
        if(myMap.containsKey(label)){
            if(!usedcategory.contains(label)){
                usedcategory.add(label);
            }
            else{
                randomFrom(myMap.get(label));
            }
        }
        else if (label.equals("number")){
            ret = ""+myRandom.nextInt(50)+5;
        } 
        else{
            ret = "**UNKNOWN**";
        } 
        return ret;
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while(trackList.contains(sub)){
            sub = getSubstitute(w.substring(first+1,last));
        }
        trackList.add(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    private int totalWordsInMap() {
        int sum = 0;
        for (String word: myMap.keySet()) {
            sum += myMap.get(word).size();
        }
        return sum;
    }
    
    private int totalWordsConsidered() {
        int sum = 0;
        for (int k = 0; k < usedcategory.size(); k++) {
            sum += myMap.get(usedcategory.get(k)).size();
        }
        return sum;
    }
    
    public void makeStory(){
        System.out.println("\n");
        trackList.clear();
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n");
        System.out.println("\nReplaced words are : " + trackList);
        System.out.println("\nReplaced words: " + trackList.size());
    }
}

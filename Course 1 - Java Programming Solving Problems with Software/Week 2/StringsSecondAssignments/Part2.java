
/**
 * HowMany - Finding Multiple Occurrences.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (V 1.0)
 * @date 15 Jan, 2019
 */
public class Part2 {
    public int howMany(String stringA, String stringB){
        int startIndex = stringB.indexOf(stringA);
        int count = 0;
        while(startIndex != -1){
            int currIndex = startIndex;
            startIndex = stringB.indexOf(stringA, currIndex + 1);
            count++;
        }
        return count;
    }
    
    public void testHowMany(){
        String A = "A"; 
        String B = "BAA"; 
        System.out.println("The string A is : " + A + " and " + "string B is : " + B);
        int result = howMany(A, B);
        System.out.println("String A occurres " + result + " times in string B");
        
        A = "AN"; 
        B = "BAANANHHD"; 
        System.out.println("The string A is : " + A + " and " + "string B is : " + B);
        result = howMany(A, B);
        System.out.println("String A occurres " + result + " times in string B");
        
        A = "ANA"; 
        B = "BAANANHHD"; 
        System.out.println("The string A is : " + A + " and " + "string B is : " + B);
        result = howMany(A, B);
        System.out.println("String A occurres " + result + " times in string B");
    }
}

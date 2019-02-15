
/**
 * Finding the gene.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (V 1.0)
 * @date - 14 Jan, 2019
 */
public class Part3 {
    public String  twoOccurrences(String stringA, String stringB){
        int indexA = stringB.indexOf(stringA);
        String result = "true";
        if(indexA == -1)
        {
            return "false";
        }
        else
        {
            int indexNew = stringB.indexOf(stringA, indexA);
            if(indexNew == -1)
            {
                return "false";
            }
        }
        return result;
    }
    
    public String lastPart(String stringA, String stringB)
    {
        int indexA = stringB.indexOf(stringA);
        String result;
        if(indexA == -1)
        {
            return stringB;
        }
        else
        {
            result = stringB.substring(indexA + stringA.length(), stringB.length());
        }
        return result;
    }
    
    public void testing()
    {
        // Test case 1
        String A = "a";
        String B = "baba";
        System.out.println("String A is : " + A + " " + "String B is : " + B);
        String output = twoOccurrences(A, B);
        System.out.println("The output is : " + output);
        // Test case 2
        A = "ana";
        B = "ansqwe";
        System.out.println("String A is : " + A + " " + "String B is : " + B);
        output = twoOccurrences(A, B);
        System.out.println("The output is : " + output);
        // Test case 3
        A = "sjhjd";
        B = "lkslka";
        System.out.println("String A is : " + A + " " + "String B is : " + B);
        output = twoOccurrences(A, B);
        System.out.println("The output is : " + output);
        
        // Calling lastPart function
        A = "an";
        B = "banana";
        System.out.println("String A is : " + A + " and " + "String B is : " + B);
        output = lastPart(A, B);
        System.out.println("The output is : " + output);
        A = "zoo";
        B = "forest";
        System.out.println("String A is : " + A + " and " + "String B is : " + B);
        output = lastPart(A, B);
        System.out.println("The output is : " + output);
    }
}

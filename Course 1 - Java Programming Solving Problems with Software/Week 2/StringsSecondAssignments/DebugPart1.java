
/**
 * Debugging Part 1 Code
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (v 1.0)
 * @date 17 Jan, 2019
 */
public class DebugPart1 {
    public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           System.out.println(index);
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           index = input.indexOf("abc",index+4);
           //System.out.println("index after updating " + index);
           System.out.println("The value is " + input);
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("kdabcabcjei");
       findAbc("ttabcesoeiabco");
       findAbc("abcbabccabcd");
       findAbc("qwertyabcuioabcp");
       findAbc("abcabcabcabca");
   }
}

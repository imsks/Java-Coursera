
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String DNA, String startCodon, String stopCodon)
    {
        // Start codon is "ATG" 
        String result = "";
        int startIndex = DNA.indexOf(startCodon);
        if (startIndex == -1)
        {
            return "";
        }
        
        int stopIndex = DNA.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1)
        {
            return "";
        }
        
        result = DNA.substring(startIndex, stopIndex + 3);
        if (result.length() % 3 != 0)
        {
            return "";
        }
        return result;
    }
    
    public void testSimpleGene()
    {
        String DNA = "GHFGHGFHGHATAA";
        System.out.println("DNA is " + DNA);
        String gene = findSimpleGene(DNA, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        DNA = "atgGCGCGCHJHJ";
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        DNA = "GCGCGCJHJFHFJtaa";
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        DNA = "ATGGVTAA";
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        DNA = "atgGKVtaa";
        DNA=DNA.toUpperCase();
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA, "ATG", "TAA");
        System.out.println("Gene is " + gene);
    }
}

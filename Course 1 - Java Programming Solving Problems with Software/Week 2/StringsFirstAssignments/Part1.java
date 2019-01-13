
/**
 * Write a description of Part1 here.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (V1.0, 12 Jan, 2019)
 */
public class Part1 {
    public String findSimpleGene(String DNA)
    {
        // Start codon is "ATG"
        String result = "";
        int startIndex = DNA.indexOf("ATG");
        if (startIndex == -1)
        {
            return "";
        }
        
        int stopIndex = DNA.indexOf("TAA", startIndex + 3);
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
        String gene = findSimpleGene(DNA);
        System.out.println("Gene is " + gene);
        
        DNA = "ATGGCGCGCHJHJ";
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA);
        System.out.println("Gene is " + gene);
        
        DNA = "GCGCGCJHJFHFJTAA";
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA);
        System.out.println("Gene is " + gene);
        
        DNA = "ATGGVTAA";
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA);
        System.out.println("Gene is " + gene);
        
        DNA = "ATGGKVTAA";
        System.out.println("DNA is " + DNA);
        gene = findSimpleGene(DNA);
        System.out.println("Gene is " + gene.toLowerCase());
    }
}

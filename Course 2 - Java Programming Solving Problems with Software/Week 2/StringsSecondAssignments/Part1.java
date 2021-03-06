
/**
 * Finding many genes.
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (V 1.0)
 * @date 15 Jan, 2019
 */
public class Part1 {
    // Code for Stop Codon
    public int findStopCodon(String DNA, int startIndex, String stopCodon){
        int currIndex = DNA.indexOf(stopCodon, startIndex + 3);
        while(currIndex != -1){
            if((currIndex - startIndex) % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = DNA.indexOf(stopCodon, currIndex + 1);
            }
        }
        return DNA.length();
    }
    public void testFindStopGene(){
        String DNAStr = "ATGAGHGTYTGAsachin"; 
        int ret = findStopCodon(DNAStr, 1, "TGA");
        System.out.println(DNAStr);
    }
    
    // Code to find gene
    public String findGene(String DNA){
        int startIndex = DNA.indexOf("ATG");
        if(startIndex == -1){
            return "Index = -1";
        }
        int TAAIndex = findStopCodon(DNA, startIndex, "TAA");
        int TAGIndex = findStopCodon(DNA, startIndex, "TAG");
        int TGAIndex = findStopCodon(DNA, startIndex, "TGA");
        int temp = Math.min(TAAIndex, TAGIndex);
        int minIndex = Math.min(temp, TGAIndex);
        if(minIndex == DNA.length()){
            return "Length Equal";
        }
        return DNA.substring(startIndex, minIndex + 3);
    }
    public void testFindGene(){
        String dna = "ABCGDHYRIJRS";
        System.out.println("The DNA is : " +  " " + dna);
        String gene = findGene(dna);
        System.out.println("The gene is : " + " " + gene); 
        
        dna = "BAVGDHGEYRATGAHBFGEH";
        System.out.println("The DNA is : " +  " " + dna);
        gene = findGene(dna);
        System.out.println("The gene is : " + " " + gene);
        
        dna = "AHUEYBOTMNJNNSKJNATGHBFTAA";
        System.out.println("The DNA is : " +  " " + dna);
        gene = findGene(dna);
        System.out.println("The gene is : " + " " + gene);
        
        dna = "AHGDURYHRJDLATGEYSTGAHJFTAGjktji";
        System.out.println("The DNA is : " +  " " + dna);
        gene = findGene(dna);
        System.out.println("The gene is : " + " " + gene);
    }
}

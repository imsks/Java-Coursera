
/**
 * Here we are parsing data from CSV Parser
 * 
 * @author (Sachin Kr. Shukla) 
 * @version (V1.0)
 * @date (03 Feb 2019)
 * 
 * Comment out to use the code.
 */

import edu.duke.*;
import org.apache.commons.csv.*;
public class CountriesExportation{
    
    public String countryInfo(CSVParser parser, String country){
        String countryInfo = null;
        for(CSVRecord record : parser){
            String countryCSV = record.get("Country");
            if(countryCSV.contains(country)){
                String exportItem = record.get("Exports");
                String exportVal = record.get("Value (dollars)");
                countryInfo = countryCSV + ":" + " " + exportItem + ":" + " " + exportVal;
            }
        }
        return countryInfo;
    }
    
   
   
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2)){
                String twoCountry = record.get("Country");
                System.out.println(twoCountry);
            }
        }
    }
    
    
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int i = 0;
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem)){
                String allCountries = record.get("Country");
                i++;
            }
        }
        return i;
    }
    
   
   
   public void bigExporters(CSVParser parser, String amount){
       for(CSVRecord record : parser){
           String value = record.get("Value (dollars)");
           if(value.length() > amount.length()){
               String allCountries = record.get("Country");
               String valueItems = record.get("Value (dollars)");
               System.out.println("The answer is " + allCountries);
            }
        }
    }
    
    
    public void tester(){
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        
        // To call countryInfo
        //String countryData = countryInfo(parser, "Nauru");
        //System.out.println(countryData);
        
        // To call listExportersTwoProducts
        
        //listExportersTwoProducts(parser, "cotton", "flowers");
        
        // To call numberOfExporters
        //int allCountriesData = numberOfExporters(parser, "cocoa");
        //System.out.println(allCountriesData);
        
        // To call bigExporters
        //System.out.println("Q");
        bigExporters(parser, "$999,999,999,999");
    }
}

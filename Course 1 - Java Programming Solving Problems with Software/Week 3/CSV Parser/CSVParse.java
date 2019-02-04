
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
public class CSVParse{
    
    public String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String countryCSV = record.get("Country");
            if(countryCSV.contains(country)){
                String exportItem = record.get("Exports");
                String exportVal = record.get("Value (dollars)");
                return countryCSV + ":" + " " + exportItem + ":" + " " + exportVal;
            }
            else{
                return "Not found";
            }
        }
        return "a";
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
    
    
    
    public String numberOfExporters(CSVParser parser, String exportItem){
        for(CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportItem)){
                String allCountries = record.get("Country");
                return allCountries;
            }
        }
        return "a";
    }
    
   
   
   public void bigExporters(CSVParser parser, String amount){
       for(CSVRecord record : parser){
           String value = record.get("Value (dollars)");
           if(value.length() > amount.length()){
               String allCountries = record.get("Country");
               String valueItems = record.get("Value (dollars)");
               System.out.println(allCountries + " " + valueItems);
            }
        }
    }
    
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // To call countryInfo
        String countryData = countryInfo(parser, "Germany");
        System.out.println(countryData);
        
        // To call listExportersTwoProducts
        //listExportersTwoProducts(parser, "gold", "diamonds");
        
        // To call numberOfExporters
        //String allCountriesData = numberOfExporters(parser, "gold");
        //System.out.println(allCountriesData);
        
        // To call bigExporters
        //bigExporters(parser, "$999,999,999");
    }
}

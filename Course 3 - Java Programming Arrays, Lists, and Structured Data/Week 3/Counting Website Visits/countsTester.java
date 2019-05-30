
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class countsTester
{
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
    
    public void countMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println("In the file, max no. of visit by an Ip is " + la.mostNumberVisitsByIP(counts));
    }
    
    public void countIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        ArrayList<String> ipsMostVisits = la.IPsMostVisits(counts);
        for(String s : ipsMostVisits){
            System.out.println("The IPs with most visits are " + s);
        }
    }
    
    public void countIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> IPsForDays = la.iPsForDays();
        for (Map.Entry<String,ArrayList<String>> entry : IPsForDays.entrySet()){
            System.out.println("The IPs and the dates are " + entry.getValue());
        }
    }
    
    public void countDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
    	System.out.println("Day with most visits: " + la.dayWithMostIPVisits(map));
    }
    
    public void testIPsWithMostVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog2_log");
    	ArrayList<String> list = la.iPsWithMostVisitsOnDay("Sep 29");
    	System.out.println("IPs with most visits on Sep 29: " + list);
    }
}
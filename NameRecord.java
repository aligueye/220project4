/*************************************************************************
 Corbin Grosso
 Ali Gueye
 CSC 220-02
 
 
 Description:
 
 Capabilities:

 *************************************************************************/

import java.util.Scanner;

public class NameRecord {

  private final int START = 1900; // the first decade (at index 0)
  private final int DECADES = 11; // the number of decades in the dataset
  private String name = ""; // the baby name
  private int[] ranks = new int[DECADES]; // the rank of the name in each decade (a rank of 0 means it was not popular enough to recieve a rank)
  
  public NameRecord(String line) {
    
    Scanner scnr = new Scanner(line);
    name = scnr.next();
    
    for (int i = 0; i < DECADES; i++) {
      
      ranks[i] = Integer.parseInt(scnr.next());
      
    }
    
  }

  public String getName() {

    return name;

  }

  public int getRank(int decade) {

    return ranks[decade];

  }

  public int bestYear() {

    // return year of index with most pop name
    return 1;

  }

  public void plot() {

    // draw shit
      
  }
  
  public String toString() {
    
    String output = "Name: " + name;
    for (int i = 0; i < DECADES; i++) {
      
      output += "\nRank in " + (START + (i * 10)) + ": " + ranks[i];
      
    }
    
    return output;
    
  }

}

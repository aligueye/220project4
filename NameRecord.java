/*************************************************************************
 Corbin Grosso
 Ali Gueye
 CSC 220-02
 
 
 Description: encapsulates the data for one name, the name and its rank over the years

 *************************************************************************/

import java.util.Scanner;

public class NameRecord {

  private final int START = 1900; // the first decade (at index 0)
  private final int DECADES = 11; // the number of decades in the dataset
  private String name = ""; // the baby name
  private int[] ranks = new int[DECADES]; // the rank of the name in each decade (a rank of 0 means it was not popular enough to recieve a rank)
  
  // constructor
  public NameRecord(String line) {
    
    Scanner scnr = new Scanner(line);
    name = scnr.next();
    
    for (int i = 0; i < DECADES; i++) {
      
      ranks[i] = Integer.parseInt(scnr.next());
      
    }
    
  } // closes constructor

  // returns the name stored in the object
  public String getName() {

    return name;

  } // closes getName method

  // returns the rank of a name in the provided decade
  public int getRank(int decade) {

    return ranks[decade];

  } // closes getRank method

  // returns the year in which the name was most popular
  public int bestYear() {

    int bestRank = 1100; // it is safe to assume every rank will be less than 1100
    int bestYear = 0; // will store the value that will eventually be output
    for (int i = 0; i < ranks.length; i++) {

      if (ranks[i] < bestRank && ranks[i] > 0) {
        
        bestRank = ranks[i];
        bestYear = START + (i * 10);
        
      }
    
    }
    
    return bestYear;

  } // closes bestYear method

  // plots the name's rank over the years as a line graph
  public void plot() {

    chooseColor();
    
    for (int i = 0; i < ranks.length - 1; i++) {
    
      double x1 = (double) i / ranks.length;
      double y1 = (double) (1100 - ranks[i]) / 1100;
      double x2 = (double) (i + 1) / ranks.length;
      double y2 = (double) (1100 - ranks[i + 1]) / 1100;
  
      // puts unranked names in the correct position
      if (ranks[i] == 0) {
        
        y1 = 0.0;
        
      }
    
      if (ranks[i + 1] == 0) {
        
        y2 = 0.0;
        
      }
      
      StdDraw.line(x1, y1, x2, y2);
      
    }
      
  } // closes plot method
  
  // overrides the toString method. Although unused by the user, it was utilized during development
  public String toString() {
    
    String output = "Name: " + name;
    for (int i = 0; i < DECADES; i++) {
      
      output += "\nRank in " + (START + (i * 10)) + ": " + ranks[i];
      
    }
    
    return output;
    
  } // closes toString method

  // returns the best rank of a name
  public int bestRank() {
    
    int bestRank = 1100; // it is safe to assume every rank will be less than 1100
    
    for (int i = 0; i < ranks.length; i++) {
      
      if (ranks[i] < bestRank && ranks[i] > 0) {
        
        bestRank = ranks[i];
        
      }
      
    }
    
    return bestRank;
    
  } // closes bestRank method

  // helper method that randomly selects a pen color for the plot method
  private static void chooseColor() {
    
    int rand = (int) Math.floor(Math.random() * 10);

    if (rand == 0) {
      
      StdDraw.setPenColor(StdDraw.BLACK);
      
    } else if (rand == 1) {
      
      StdDraw.setPenColor(StdDraw.BLUE);
      
    } else if (rand == 2) {
      
      StdDraw.setPenColor(StdDraw.CYAN);
      
    } else if (rand == 3) {
      
      StdDraw.setPenColor(StdDraw.DARK_GRAY);
      
    } else if (rand == 4) {
      
      StdDraw.setPenColor(StdDraw.GRAY);
      
    } else if (rand == 5) {
      
      StdDraw.setPenColor(StdDraw.GREEN);
      
    } else if (rand == 6) {
      
      StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
      
    } else if (rand == 7) {
      
      StdDraw.setPenColor(StdDraw.MAGENTA);
      
    } else if (rand == 8) {
      
      StdDraw.setPenColor(StdDraw.ORANGE);
      
    } else if (rand == 9) {
      
      StdDraw.setPenColor(StdDraw.PINK);
      
    } else if (rand == 10) {
      
      StdDraw.setPenColor(StdDraw.RED);
      
    } else if (rand == 0) {
      
      StdDraw.setPenColor(StdDraw.YELLOW);
      
    }
    
  } // closes chooseColor method

}

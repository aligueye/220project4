/*************************************************************************
 Corbin Grosso
 Ali Gueye
 CSC 220-02
 
 
 Description: Driver Class for the NameRecord object class

 *************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NameSurfer {
  
  public static void main(String[] args) {
    // read all names into array of name records
    
    File file = new File("name_data.txt");
    ArrayList<NameRecord> names = new ArrayList<NameRecord>();
    Scanner scnr; // Scanner object, used to read files and user input
    int choice = -1; // used to hold user's choices after prompts
    boolean quit = false; // quit condtion of program
    String userName = ""; // name user enters into program
    NameRecord selectedName = null; // reference used for word selected
    int userDecade = -1; // int of decade user request to see rank from
    
    try {

      scnr = new Scanner(file);
            
      while (scnr.hasNextLine()) {

        names.add(new NameRecord(scnr.nextLine()));

      }
      
    } catch (FileNotFoundException e) {

      e.printStackTrace();

    }
    
    // System.out.println(names.get(0).getName()+" "+names.get(4428).getName());
    
    // loop continues until a plot is cleared or program selects to quit program
    while (!quit) {

      System.out.println("1 – Find best year for a name\n" +
                         "2 – Find best rank for a name\n" +
                         "3 – Plot popularity of a name\n" +
                         "4 – Clear plot\n" +
                         "5 – Quit\n" +
                         "Enter your selection.\n");
    
      scnr = new Scanner(System.in);
      choice = scnr.nextInt();
      
      if (choice < 4 && choice > 0) {

        System.out.println("Enter a name\n");
        userName = scnr.next();
        if (nameFound(names, userName)) { // Returns true if name is in the array

          for (NameRecord name : names) {

            if (name.getName().equalsIgnoreCase(userName)) {

              selectedName = name;

            }

          }

          switch(choice) {
            
            case 1: // find the best year for a name
              
              System.out.println("Best year for this name was " + selectedName.bestYear() + "\n");
              break;
            
            case 2: // find the best rank for a name
              
              System.out.println("Best rank for this name was " + selectedName.bestRank() + "\n");
              break;
            
            case 3:
              
              System.out.println("Plotting graph\n");
              selectedName.plot();
              break;

          }

        } else {

          System.out.println("Error: name not found\n");

        }

      } else if (choice == 4) {

        StdDraw.clear();
        quit = true;

      } else if (choice == 5) { 

        quit = true;

      } else {
        
        System.out.println("Invalid option");
        
      }

    } // closes while loop
    
  } // closes main method
  
  // helper method to quickly return true if the name entered by the user exists in the data
  private static boolean nameFound(ArrayList<NameRecord> names, String userName) { 
    
    for (NameRecord name : names) {

      if (name.getName().equalsIgnoreCase(userName)) {

        return true;

      }

    }

    return false;

  } // closes nameFound method

} // closes NameSurfer class

/*************************************************************************
 Corbin Grosso
 Ali Gueye
 CSC 220-02
 
 
 Description: Driver Class
 
 Capabilities:

 *************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NameSurfer {
  
  public static void main(String[] args) {

    File file = new File("name_data.txt"); // Allows us to pass name data into scanner input stream
    ArrayList<NameRecord> names = new ArrayList<NameRecord>(); // array list of NameRecord objects, used for iterations
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
      
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    System.out.println(names.get(0).getName()+" "+names.get(4428).getName());
    
    // Assigns scnanner to user input instead of names file 
    scnr = new Scanner(System.in);

    // loop continues until a plot is cleared or program selects to quit program
    while (!quit) {
      System.out.println("1 – Find best year for a name\n" +
                         "2 – Find given rank for a name\n" +
                         "3 – Plot popularity of a name\n" +
                         "4 – Clear plot\n" +
                         "5 – Quit\n" +
                         "Enter your selection.\n");
    
      choice = scnr.nextInt();
      
      if (choice < 4 && choice > 0) {
        
        System.out.println("\nEnter a name\n");
        userName = scnr.next();

        if (nameFound(names, userName)) {
          
          // If name is found, assigns given name the selectedName reference
          for (NameRecord name : names) {
            if (name.getName().equalsIgnoreCase(userName)) {
              selectedName = name;
            }
          }

          switch(choice) {
            
            case 1:
              
              System.out.println("\nBest year for this name was " + selectedName.bestYear() + "\n");
              break;
            
            case 2:
              
              System.out.println("\nEnter decade to find rank in\n");
              userDecade = scnr.nextInt();
              
              // Checks if user enters valid decade
              while (userDecade < 0 || userDecade > 10) {
                System.out.println("\nEnter valid decade between: 0-10\n");
                userDecade = scnr.nextInt();
              }

              System.out.println("\nRank for decade " + (1900 + (userDecade * 10)) + " was " + selectedName.getRank(userDecade) + "\n");
              break;
            
            case 3:
              
              System.out.println("\nPlotting graph...\n");
              selectedName.plot();
              break;
          }
        }
        else {
          System.out.println("\nError: name not found\n");
        }
      } 
      else if (choice == 4) {
        StdDraw.clear();
      }
      else {
        quit = true;
      }

    }
    
  }
  
  // Checks if user entered name is a part of the names data
  private static boolean nameFound(ArrayList<NameRecord> names, String userName) { 
    
    for (NameRecord name : names) {

      if (name.getName().equalsIgnoreCase(userName)) {
        return true;
      }

    }

    return false;

  }

}

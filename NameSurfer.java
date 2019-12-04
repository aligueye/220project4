/*************************************************************************
 Corbin Grosso
 Ali Gueye
 CSC 220-02
 
 
 Description: Driver Class
 
 Capabilities:

 *************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameSurfer {
    
  public static void main(String[] args) {
    // read all names into array of name records
    File file = new File("name_data.txt");
    int count = 0;
    try {
      Scanner scnr = new Scanner(file);
            
      while (scnr.hasNextLine()) {
        scnr.nextLine();
        count++;
      }
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println(count);
    // also shit to 'play' 
        
    }

}
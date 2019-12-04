/*************************************************************************
 Corbin Grosso
 Ali Gueye
 CSC 220-02
 
 
 Description:
 
 Capabilities:

 *************************************************************************/

public class NameRecord {

  private final int START = 1900;
  private final int DECADES = 11;
  private String name = "";
  private int[] ranks = new int[DECADES];
    
  
  public NameRecord(String name) {
    // code code code
    this.name = name;
  }

  public String getString() {
    return name;
  }

  public int getRank(int decade) {
    // index of decade 
    return 1;
  }

  public int bestYear() {
    // return year of index with most pop name
    return 1;
  }

  public void plot() {
    // draw shit
  }

}
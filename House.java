/* This is a stub for the House class */
import java.util.ArrayList;
import javax.management.RuntimeErrorException;
import java.lang.Math;

public class House extends Building{

  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /** Default Constructor */
  public House(){
    this("<Name Unknown>", "<Address Unknown>", 1,false,false);
  }

  /**
   * Overloaded constructor with name, address and number of floors
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors of the house
   */
  public House(String name, String address, int nFloors){
    this();
    this.name = name;
    this.address = address;
    this.nFloors = nFloors;
  }

  /**
   * Overloaded constructor with name, address, number of floors and indicate if it has a dining room
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors of the house
   * @param hasDiningRoom indicate if the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom){
    this();
    this.name = name;
    this.address = address;
    this.nFloors = nFloors;
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * Full constructor
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors of the house
   * @param hasElevator indicate if the house has a dining room
   * @param hasDiningRoom indicate if the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasElevator, boolean hasDiningRoom) {
    super(name, address, nFloors);
    System.out.println("You have built a house 🏠: " + this.name);
    this.residents = new ArrayList<String>();
    this.hasElevator = hasElevator;
    this.hasDiningRoom = hasDiningRoom;
  }

  /**
   * Getter for hasDiningRoom
   * @return if the house has dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Getter for the size of array list resident
   * @return the number of residents in the house
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Check if someone lives in the house
   * @param person pass in the person you want to inquire
   * @return whether the person lives in the house
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  /**
   * Add a person to the house
   * @param name indicate the person you want to add to the house
   */
  public void moveIn(String name){
    if (this.isResident(name)){
      throw new RuntimeException(name + "is already in the house!");    /* check if the person is already in the house */
    }
    else{
      residents.add(name);
      System.out.println("Hi, " + name + "! Welcome to " + this.name + "!");
    }
  }

  /**
   * Remove a person from the house
   * @param name indicate the person you want to move out of the house
   * @return the name of the person moved out
   */
  public String moveOut(String name){
    if(!this.isResident(name)){
      throw new RuntimeException("Sorry, " + name + " is not in " + this.name);
    }
    else{
      residents.remove(name);
      System.out.println("Bye-bye, " + name + "!");
      return name;
    }
  }

  /**
   * Go up or down to different floors
   * @param floorNum indicate which floor you want to get to
   */
  public void goToFloor(int floorNum){
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside " + this.name + ". Must call enter() before navigating between floors.");
    }
    if (this.hasElevator == true){
      super.goToFloor(floorNum);
    }
    else if(this.hasElevator == false){
      // check if the floors are adjacent
      if (floorNum == this.activeFloor){
        throw new RuntimeException("You're not moving between floors. Please enter another number.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      if (Math.abs(floorNum - this.activeFloor) > 1){
        throw new RuntimeException("Sorry, the house doesn't have an elevator so you can't move to non-adjacent floors. Please enter another number.");
      }
      else{
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
    }
  }

  /**
   * Show the possible functionalities of houses
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + moveIn(someone) \n + moveOut(someone) \n + goToFloor(#)");
  }

  /* Do some printing */
  public String toString(){
    return this.name + " is a house at " + this.address + " with " + this.nResidents() + " residents.";
  }

  public static void main(String[] args) {
      House Tyler = new House("Tyler", "164 Green Street Northampton, MA 01063", 4, false, true);
      System.out.println(Tyler);
      Tyler.enter();
      Tyler.goToFloor(2);
      Tyler.moveIn("A");
      System.out.println(Tyler);
  }
}
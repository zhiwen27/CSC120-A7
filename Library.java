/* This is a stub for the Library class */
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  /** Default Constructor */
  public Library(){
    this("<Name Unknown>", "<Address Unknown>", 1);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Overloaded constructor with name and address
   * @param name the name of the library
   * @param address the address of the library
   */
  public Library(String name, String address){
    this();
    this.name = name;
    this.address = address;
  }

  /**
   * Full constructor
   * @param name the name of the library
   * @param address the address of the library
   * @param nFloors the number of floors of the house
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a library 📖: " + this.name);
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Check if the collection contains some book
   * @param title pass in the title of the book you want to check
   * @return whether the book is in the collection
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * Check if the book is now available
   * @param title pass in the title of the book you want to check
   * @return whether the book is now available
   */
  public boolean isAvailable(String title){
    return this.collection.get(title);
  }

  /**
   * Add a new book into the collection
   * @param title the title of the book you want to add to the collection
   */
  public void addTitle(String title){
    if (this.containsTitle(title)){
      throw new RuntimeException("Oops! The book " + title + " is already in the collection.");
    }
    else{
      this.collection.put(title, true);
      System.out.println("Successfully add " + title + " to the collection!");
    }
  }

  /**
   * Remove a book from the collection
   * @param title the title of the book you want to remove from the collection
   */
  public String removeTitle(String title){
    if (!this.containsTitle(title)){
      throw new RuntimeException("Sorry, the book " + title + " is not in our collection.");
    }
    else if (!this.isAvailable(title)){
      throw new RuntimeException("Sorry, the book " + title + " is now borrowed, you cannot remove it.");
    }
    else{
      this.collection.remove(title);
      System.out.println("Successfully remove " + title + " from the collection!");
      return title;
    }
  }

  /**
   * Check out a book
   * @param title the title of the book you want to borrow
   */
  public void checkOut(String title){
    if (!this.containsTitle(title) || (!this.isAvailable(title))){
      throw new RuntimeException("Sorry, you cannot borrow the book " + title + " right now.");
    }
    else{
      this.collection.put(title, false);
      System.out.println("Successfully check out the book: " + title + "!");
    }
  }

  /**
   * Return a book
   * @param title the title of the book you return
   */
  public void returnBook(String title){
    if (!this.containsTitle(title)){
      throw new RuntimeException("Invalid operation——————there must be something wrong!");
    }
    else{
      this.collection.put(title,true);
      System.out.println("Successfully return the book: " + title + "!");
    }
  }

  /**
   * Printer for all the books now in the collection
   */
  public void printCollection(){
    Enumeration<String> keys = this.collection.keys();
    int num = 1;    // Simply indicate the number of the book
    while(keys.hasMoreElements()){
      System.out.println("Book " + num + ": " + keys.nextElement());
      num++;
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
    if (floorNum == this.activeFloor){
      throw new RuntimeException("You're not moving between floors. Please enter another number.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    super.goToFloor(floorNum);
  }

  /**
   * Show the possible functionalities of libraries
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) + \n + printCollection() + goToFloor(n)");
  }

  /* Do some printing */
  public String toString(){
    return this.name + " is a library at " + this.address + " with " + this.collection.size() + " books";
  }

  public static void main(String[] args) {
    Library Neilson = new Library("Neilson Library", "7 Neilson Dr Northampton, MA 01063", 4);
    System.out.println(Neilson);
    Neilson.enter();
    Neilson.goToFloor(3);
  }
}
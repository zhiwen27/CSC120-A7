/* This is a stub for the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; /* The number of ounces of coffee remaining in inventory */
    private int nSugarPackets; /* The number of sugar packets remaining in inventory */
    private int nCreams; /* The number of "splashes" of cream remaining in inventory */
    private int nCups; /* The number of cups remaining in inventory */

    /** Default Constructor */
    public Cafe(){
        this("<Name Unknown>", "<Address Unknown>", 1);
        this.restock(100, 100, 100, 100);
    }

    /**
   * Overloaded constructor with name and address
   * @param name the name of the cafe
   * @param address the address of the cafe
   */
    public Cafe(String name, String address){
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
    public Cafe(String name, String address, int nFloors){
        super(name, address, nFloors);
        System.out.println("You have built a cafe ☕: " + this.name);
        /* initialize all the items inside the inventory to be zero */
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
    }

    /**
     * Decrease the remaining inventory after selling a cup of coffee
     * @param size the size of coffee
     * @param nSugarPackets the number of sugar packets required
     * @param nCreams cream required
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if ((this.nCoffeeOunces < size) || (this.nSugarPackets < nSugarPackets) || (this.nCreams < nCreams) || (this.nCups < 1)){
            System.out.println("There aren't enough inventories... need restock!");
            restock(size - this.nCoffeeOunces, nSugarPackets - this.nSugarPackets, nCreams - this.nCreams, 1);
        }
        else{
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }

    /**
     * Restock the inventory of the cafe
     * @param nCoffeeOunces the number of ounces of coffee added to the supplement
     * @param nSugarPackets the number of sugar packets added to the supplement
     * @param nCreams cream added to the supplement
     * @param nCups the number of cups added to the supplement
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > 1){
            throw new RuntimeException("Sorry, you cannot enter staff-only areas. Please enter another number.");
        }
        if (floorNum == 1){
            System.out.println("Hmm... it seems you've figured out that you cannot move around. Enjoy your coffee!");
        }
    }

    /**
     * Show the possible functionalities of cafes
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee(size, sugar, cream) \n + restock(coffee, sugar, cream, cup)");
      }

    /* Do some printing */
    public String toString(){
        return this.name + " now has " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " sugar packets, " + this.nCreams + " splashes of creams, and can take " + this.nCups + " more orders.";
    }

    public static void main(String[] args) {
        Cafe campusCenter = new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 2);
        System.out.println(campusCenter);
        campusCenter.sellCoffee(2, 1, 1);
        System.out.println(campusCenter);
        campusCenter.enter();
        campusCenter.goToFloor(1);
        campusCenter.showOptions();
    }
}

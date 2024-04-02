import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "44 College Ln Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Smith College Conference Center", "49 College Ln Northampton, MA 01063"));
        myMap.addBuilding(new House("Tyler House", "164 Green Street Northampton, MA 01063", 4,true));
        myMap.addBuilding(new House("Cutter House", "79 Elm Street Northampton, MA 01063", 3, true, true));
        myMap.addBuilding(new House("Washburn House","32 Elm Street Northampton, MA 01063",3));
        myMap.addBuilding(new House("Cushing House","35 Paradise Pond Northampton, MA 01063",4,true));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 2));
        myMap.addBuilding(new Cafe("Compass Cafe","7 Neilson Dr Northampton, MA 01063"));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Dr Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Hillyer Art Library", "20 Elm Street Northampton, MA 01063", 3));
        System.out.println(myMap);
        /*System.out.println("  Welcome to Smith College! We hope you could have a wonderful time here! \n Would you like to start the journey now? \n *Please type in YES if you want.");
        Building activeBuilding = null;
        Scanner sc = new Scanner(System.in);
        String userInput;
        userInput = sc.nextLine();
        while (myMap.toPlay(userInput)){
            System.out.println("Great! Please indicate the building you want to go first! *Please type in the building number according to the directory.");
            System.out.println(myMap);
            Integer buildingNum;
            buildingNum = sc.nextInt();
            while (myMap.toPlay(userInput)){
                activeBuilding = myMap.buildings.get(buildingNum - 1);
                activeBuilding.showOptions();
                System.out.println("Do you want to move around? \n *Please type in YES if you want.");
                sc.nextLine();
                userInput = sc.nextLine();
                if (userInput.contains("Yes") || userInput.contains("Yes") || userInput.contains("yes")){
                    if (activeBuilding.activeFloor != 1){
                        activeBuilding.enter();
                    }
                    else{
                        continue;
                    }
                    if (activeBuilding instanceof House){
                        System.out.println("Great! Tell us what you would like to do next! \n *Please type in the exact method name.");
                        House activeHouse = (House) activeBuilding;
                        userInput = sc.nextLine();
                        if (userInput.contains("move in") || userInput.contains("moveIn")){
                            System.out.println("Great! Please tell us your name!");
                            userInput = sc.nextLine();
                            try{
                                activeHouse.moveIn(userInput);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (userInput.contains("move out") || userInput.contains("moveOut")){
                            System.out.println("Alright! Please tell us your name!");
                            userInput = sc.nextLine();
                            try{
                                activeHouse.moveOut(userInput);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (userInput.contains("floor") || userInput.contains("goToFloor")){
                            System.out.println("Alright! Please tell us which floor you want to go to!");
                            Integer floorNum;
                            floorNum = sc.nextInt();
                            try{
                                activeHouse.goToFloor(floorNum);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    else if (activeBuilding instanceof Library){
                        Library activeLibrary = (Library) activeBuilding;
                        activeLibrary.addTitle("Book 1");
                        activeLibrary.addTitle("Book 2");
                        activeLibrary.addTitle("Book 3");
                        System.out.println("Great! Tell us what you would like to do next! \n *Please type in the exact method name.");
                        userInput = sc.nextLine();
                        if (userInput.contains("check out") || userInput.contains("checkOut")){
                            System.out.println("Okay! These are the books now in our collection!");
                            activeLibrary.printCollection();
                            System.out.println("Please tell us the book you want to borrow! \n *Please type in the name of the book.");
                            userInput = sc.nextLine();
                            try{
                                activeLibrary.checkOut(userInput);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (userInput.contains("return") || userInput.contains("returnBook")){
                            System.out.println("Great! Please tell us the book you want to return! \n *Please type in the name of the book.");
                            userInput = sc.nextLine();
                            try{
                                activeLibrary.returnBook(userInput);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (userInput.contains("floor") || userInput.contains("goToFloor")){
                            System.out.println("Alright! Please tell me which floor you want to go to!");
                            Integer floorNum;
                            floorNum = sc.nextInt();
                            try{
                                activeLibrary.goToFloor(floorNum);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    else if (activeBuilding instanceof Cafe){
                        System.out.println("Great! Tell us what you would like to do next! \n *Please type in the exact method name.");
                        Cafe activeCafe = (Cafe) activeBuilding;
                        userInput = sc.nextLine();
                        if (userInput.contains("buy") || userInput.contains("sellCoffee")){
                            System.out.println("Okay! Please tell us the size of the coffee you would like!");
                            Integer size;
                            Integer sugar;
                            Integer cream;
                            size = sc.nextInt();
                            System.out.println("Great! And the sugar you would like!");
                            sugar=sc.nextInt();
                            System.out.println("And the cream!");
                            cream = sc.nextInt();
                            try{
                                activeCafe.sellCoffee(size,sugar,cream);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else if (userInput.contains("floor") || userInput.contains("goToFloor")){
                            System.out.println("Alright! Please tell me which floor you want to go to!");
                            Integer floorNum;
                            floorNum = sc.nextInt();
                            try{
                                activeCafe.goToFloor(floorNum);
                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                            sc.nextLine();
                        }
                    }
                }
            }
            System.out.println("Do you want to stay here?");
            // sc.nextLine();
            userInput = sc.nextLine();
        }
        System.out.println("Alright! Hope you've enjoyed our tour!");
        sc.close();*/
    }
}
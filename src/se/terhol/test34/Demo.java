package se.terhol.test34;

import java.io.IOException;

/**
 * 
 * @author   Ales  Zlamal
 * @version  2010 11 13
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        House h = null;
        
        System.out.print("Reading data from directConnections.txt...");
        h = new HouseImpl("directConnections.txt");
        System.out.println("OK");
        
        
        Person p1 = new Person("Louis Charles August");
        Person p2 = new Person("Charlotte");
        Person p3 = new Person("Viviane");
        Person p4 = new Person("Raoul");
        Person p5 = new Person("Alasdair");
        Person p6 = new Person("Raquelle");
        
        Person p7 = new Person("Vasek");
        
        h.placePerson(p1, new Room("grand salon"));
        h.placePerson(p2, new Room("entrance hall"));
        h.placePerson(p3, new Room("grand salon"));
        h.placePerson(p4, new Room("entrance hall"));
        h.placePerson(p5, new Room("workroom"));
        h.placePerson(p6, new Room("connecting gallery"));
        
        try{
            System.out.print("enterNextDoor() -- unknown person: ");
            h.enterNextDoor(p7, new Room("ballroom"));
            System.out.println("ERROR");
        }catch(IllegalArgumentException iae){
            System.out.println("OK");
        }
        try{
            System.out.print("enterNextDoor() -- unknown room: ");
            h.enterNextDoor(p3, new Room("glasshouse")); 
            System.out.println("ERROR");
        }catch(IllegalArgumentException iae){
            System.out.println("OK");
        }
        try{
            System.out.print("placePerson() -- replacing person: ");
            h.placePerson(p3, new Room("workroom"));
            if (h.whereIs(p3).equals(new Room("workroom"))) {
                System.out.println("OK, " + p3 + " is in \"workroom\".");
            } else {
                System.out.println("ERROR");
            }
        }catch(IllegalArgumentException iae){
            System.out.println("ERROR");
        }
        
        try{
            System.out.print(p3);
            h.enterNextDoor(p3, new Room("ballroom"));
            System.out.println(" entered \"ballroom\": ERROR");
        }catch(IllegalArgumentException due){
            System.out.println(" doesn't entered \"ballroom\": OK");
        }
        
        try{
            System.out.print("Moving various persons to their neighbouring rooms: ");
            h.enterNextDoor(p6, new Room("ballroom")); 
            h.enterNextDoor(p1, new Room("connecting gallery")); 
            h.enterNextDoor(p2, new Room("connecting gallery")); 
            h.enterNextDoor(p3, new Room("salon bordeaux")); 
            h.enterNextDoor(p1, new Room("ballroom")); 
            h.enterNextDoor(p2, new Room("ballroom")); 
            System.out.println("OK");
        }catch(IllegalArgumentException due){
            System.out.println("ERROR: " + due);
        }

        System.out.print(p3 +" is in \"" + h.whereIs(p3) + "\". ");
        System.out.println(p6 + " is in \"" + h.whereIs(p6) + "\".");
        
        System.out.println();
        System.out.println("savePlan() -- line order doesn't matter: ");
        h.savePlan(System.out);
    }
}
 

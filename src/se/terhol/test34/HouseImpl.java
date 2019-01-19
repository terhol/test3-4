package se.terhol.test34;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Tereza Holm
 */
public class HouseImpl implements House {
    Map<Room, Set<Room>> house = new HashMap<>();
    Map<Person, Room> currentHouse = new HashMap<>();

    public HouseImpl(String input) throws IOException {
        InputStream is = Files.newInputStream(Paths.get(input));
        this.loadPlan(is);
    }

    @Override
    public void placePerson(Person person, Room room) {
        if (person == null) {
            throw new IllegalArgumentException();
        }
        currentHouse.put(person, room);
    }

    @Override
    public Room whereIs(Person person) {
        return currentHouse.get(person);
    }

    @Override
    public void enterNextDoor(Person person, Room room) {
        if (!currentHouse.containsKey(person) || !this.isNext(currentHouse.get(person), room)) {
            throw new IllegalArgumentException();
        }
        this.placePerson(person, room);
    }

    @Override
    public void savePlan(OutputStream os) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
            for (Room room : house.keySet()) {
                for (Room roomNext : house.get(room)) {
                    writer.write(String.format("%1$s:%2$s", room.toString(), roomNext.toString()));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("IO error");
        }
    }

    @Override
    public void loadPlan(InputStream is) {
        Scanner reader = new Scanner(is);

        String line;

        while (reader.hasNextLine()) {
            line = reader.nextLine();
            int spaceInt = line.indexOf(":");
            Room room1 = new Room(line.substring(0, spaceInt));
            Room room2 = new Room(line.substring(spaceInt + 1));
            this.addRom(room1, room2);
            this.addRom(room2, room1);
        }
    }

    private boolean isNext(Room room1, Room room2) {
        if (!house.containsKey(room1) || !house.containsKey(room2)) {
            throw new IllegalArgumentException();
        }
        return house.get(room1).contains(room2);
    }

    private void addRom(Room room1, Room room2) {
        if (!house.containsKey(room1)) {
            house.put(room1, new HashSet<>());
        }
        house.get(room1).add(room2);
    }
}

package se.terhol.test34;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * House.
 *
 * @author Ales  Zlamal
 * @version 2011 01 12
 */
public interface House {
    /**
     * Places given person to concrete room of this house. If the person is
     * already present in the house then he/she is moved to the new room.
     *
     * @param person Person
     * @param room   Room
     * @throws IllegalArgumentException if the person parameter is null
     * @throws IllegalArgumentException if this house has not required room
     */
    void placePerson(Person person, Room room);

    /**
     * Locates person in this house.
     *
     * @param person Person of interest
     * @return room where the person is located,
     * null if the person is not in the house
     */
    Room whereIs(Person person);

    /**
     * Moves person from actual room into the neighbouring room.
     *
     * @param person Moving person
     * @param room   Room to move into (must be the neighbouring room of actual room of the person)
     * @throws IllegalArgumentException if the person parameter is null or
     *                                  the person is not in the house
     * @throws IllegalArgumentException if the given room is not neighbouring room
     */
    void enterNextDoor(Person person, Room room);

    /**
     * Writes plan of this house (only rooms without people and their location!)
     * to output stream as follows:
     * 1. Data are written in text mode.
     * 2. Pairs of the next door rooms (rooms with common door) are written
     * to single line, rooms are separated by colon ":".
     *
     * @param os Output stream
     * @throws IOException on any I/O error
     */
    void savePlan(OutputStream os) throws IOException;

    /**
     * Reads the house plan from given input stream and instantiates the plan
     * in memory. For the format see savePlan().
     *
     * @param is Input stream
     * @throws IOException on any I/O failure
     */
    void loadPlan(InputStream is) throws IOException;
}

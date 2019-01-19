package se.terhol.test34;

/**
 * Room.
 *
 * @author Radek Oslejsek
 * @version 2011-01-10
 */
public class Room {
    private String name;

    /**
     * @param name Room's name, must not be null nor empty
     * @throws IllegalArgumentException if name is null or consists of empty string
     */
    public Room(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("name");
        }
        this.name = name.trim();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return this.name.equals(((Room) obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

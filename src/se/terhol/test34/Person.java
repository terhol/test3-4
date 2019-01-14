package se.terhol.test34;

/**
 * Person.
 * 
 * @author Radek Oslejsek
 * @version 2011-01-10
 */
public class Person
{
    private String name;
    
    /**
     * @param name Person's name, must not be null nor empty
     * @throws IllegalArgumentException if name is null or 
     *         consists of empty string
     */
    public Person(String name) {
        if(name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("name");
        }
        this.name = name.trim();
    }
    
    @Override
    public String toString() {
        return name;
    }
}

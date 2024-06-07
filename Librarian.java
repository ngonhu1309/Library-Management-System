/**
 * This class represents a librarian working in a library.
 *
 * @author Nhu Ngo
 */

public class Librarian implements Cloneable {
    
    // =============== Instance Variables ===============
    protected int id;
    protected String type;
    protected String firstName;
    protected String lastName;
    protected String area;
    
    // =============== Constructors ===============
    /**
     * The null librarian object.
     */
    public Librarian() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.area = "";
    }
    
    /**
     * Parameterized constructor to initialize a Item object with given values
     * for id, type, title, year, borrowed.
     * 
     * @param type        The librarian.
     * @param id          The id of the librarian.
     * @param firstName   The first name of the librarian.
     * @param lastName    The last name of the librarian.
     * @param area        The area that the librarian works in.
     */
    public Librarian(String type, int id, String firstName, 
            String lastName, String area) {
        this.type = type;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.area = area;
    }
    
    /**
     * Method to return the id of the librarian.
     * 
     * @return a integer value.
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Method to return the full name of the librarian.
     * 
     * @return a string value.
     */
    public String getName() {
        return this.firstName + " " + this.lastName;
    }
    
    /**
     * Method to return the area that the librarian works.
     * 
     * @return a string value.
     */
    public String getArea() {
        return this.area;
    }
    
    /**
     * Method to change the full name of the librarian.
     * 
     * @param newFirstName The new first name of the librarian.
     * @param newLastName  The new last name of the librarian.
     */
    public void changeName(String newFirstName, String newLastName) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
    }
    
    /**
     * Method to return the area of the librarian works in.
     * 
     * @param newArea   The name of the new area the librarian works in.
     */
    public void changeArea(String newArea) {
        this.area = newArea;
    }
    
    /**
     * Method to check if the 2 Librarian objects 
     * are equal if they are in the same Java
     * class.
     * 
     * @return false.
     */
    public boolean equals(Object obj) {
        boolean flag = false;
        
        // Check to see if the obj is null
        if (obj == null) {
            return false;
        }
        
        // Check to see if the obj belong to the same class
        if (obj instanceof Librarian) {
            Librarian other = (Librarian) obj;
            flag = this.getId() == (other.getId());
        }
        return flag;
    }
    
    /**
     * This method creates a deep copy of this object.
     * 
     * @return a deep copy of this object.
     */
    @Override
    public Librarian clone() {
        return new Librarian();
    }
    
    /**
     * This method prints out the summary of the librarians.
     * @return String value
     */
    public String printSummary() {
        return "Librarian " + getName() + " works at the " 
             + this.area + " section.";
    }
    
    /**
     * Method to show how to print inside the test file.
     * 
     * @return a string value.
     */
    public String toString() {
        return this.type + "\t" + this.id + "\t" + this.firstName 
            + "\t" + this.lastName + "\t" + this.getArea() + "\t";
    }
    
}

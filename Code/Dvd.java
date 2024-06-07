/**
 * This is a simple Dvd class extends from Item class.
 *
 * @author Nhu Ngo
 */

// The keyword extends means this class inherit from Item class
public class Dvd extends Item {
    
    // =============== Instance Variables ===============
    protected String publisher;
    protected int duration;
    
    // =============== Constructors ===============
    /**
     * Parameterized constructor to initialize a Item object with given values
     * for id, type, title, year, borrowed.
     * 
     * @param id         The id of the dvd.
     * @param type       The type of the dvd.
     * @param title      The title of the dvd.
     * @param borrowed   The flag to check whether this dvd is borrowed or not.
     * @param publisher  The publisher of the dvd.
     * @param duration   The duration of the dvd.
     */
    public Dvd(String type, int id, String title, boolean borrowed, 
             String publisher, int duration) {
        super(type, id, title, borrowed);
        this.publisher = publisher;
        this.duration = duration;
    }
    
    /**
     * The dvd object.
     * 
     * @param dvd The dvd object.
     */
    public Dvd(Dvd dvd) {
        // TODO Auto-generated constructor stub
    }

    /**
     * Method to return the publisher of the dvd.
     * 
     * @return a string value.
     */
    public String getpublisher() {
        return this.publisher;
    }
    
    /**
     * Method to return the duration of the dvd.
     * 
     * @return a integer value.
     */
    public int getDuration() {
        return this.duration;
    }
    
    /**
     * Method to change the publisher of the dvd.
     * 
     * @param newName The new name of the publisher.
     */
    public void changepublisher(String newName) {
        this.publisher = newName;
    }
    
    /**
     * Method to change the version of the dvd.
     * 
     * @param newDuration the new duration of the dvd.
     */
    public void changeVersion(int newDuration) {
        this.duration = newDuration;
    }
    
    /**
     * Method to return the type of the item.
     * 
     * @return a string value.
     */
    @Override
    public String getType() {
        return "dvd";
    }
    
    /**
     * This method creates a deep copy of this object.
     * 
     * @return a deep copy of this object.
     */
    @Override
    public Dvd clone() {
        return new Dvd(this);
    }
    
    /**
     * Method to show how to print inside the test file.
     * 
     * @return a string value.
     */
    public String toString() {
        return super.toString() + "\t" + this.publisher 
             + "\t" + this.duration + "\t";
    }
    
    /**
     * Method to print the information of the DVD
     */
    @Override
    public void printInfo() {
    	System.out.println("Title: " + this.title);
    	System.out.println("Publisher: " + this.publisher);
    	System.out.println("Duration: " + this.duration);
    }
}

/**
 * This is a simple Book class extends from Item class.
 *
 * @author Nhu Ngo
 */

// The keyword extends means this class inherit from Item class
public class Book extends Item {
    
    // =============== Instance Variables ===============
    protected String author;
    protected int version;
    
    // =============== Constructors ===============
    /**
     * Parameterized constructor to initialize a Item object with given values
     * for id, type, title, year, borrowed.
     * 
     * @param id         The id of the book.
     * @param type       The type of the book.
     * @param title      The title of the book.
     * @param borrowed   The flag to check whether this book is borrowed or not.
     * @param author     The author of the book.
     * @param version    The version of the book.
     */
    public Book(String type, int id, String title, 
            boolean borrowed, String author, int version) {
        super(type, id, title, borrowed);
        this.author = author;
        this.version = version;
    }
    
    /**
     * The null book object.
     * 
     * @param book The object of the book
     */
    public Book(Book book) {
        this.author = "";
        this.version = 0;
    }
    
    /**
     * Method to return the author of the book.
     * 
     * @return a string value.
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     * Method to return the version of the book.
     * 
     * @return a integer value.
     */
    public int getVersion() {
        return this.version;
    }
    
    /**
     * Method to change the author name of the book.
     * 
     * @param newName the new name of the author.
     */
    public void changeAuthor(String newName) {
        this.author = newName;
    }
    
    /**
     * Method to change the version of the book.
     * 
     * @param newVersion the number of the version.
     */
    public void changeVersion(int newVersion) {
        this.version = newVersion;
    }
    
    /**
     * This method creates a deep copy of this object.
     * 
     * @return a deep copy of this object.
     */
    @Override
    public Book clone() {
        return new Book(this);
    }
    
    /**
     * Method to return the type of the item.
     * 
     * @return a string value.
     */
    @Override
    public String getType() {
        return "book";
    }
    
    /**
     * Method to show how to print inside the test file.
     * 
     * @return a string value.
     */
    public String toString() {
        return super.toString() + "\t" + this.author 
            + "\t" + this.version + "\t";
    }
    
    /**
     * Method to print the information of the book
     */
    @Override
    public void printInfo() {
    	System.out.println("Title: " + this.title);
    	System.out.println("Author: " + this.author);
    	System.out.println("Version: " + this.version);
    }
}

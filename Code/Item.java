/**
 * This is a simple item class for books and DVDs.
 *
 * @author Nhu Ngo
 */

public class Item implements Borrowable {
    
    // =============== Instance Variables ===============
    protected int id;
    protected String type;
    protected String title;
    protected boolean borrowed;
    
    // =============== Constructors ===============
    /**
     * The null item object.
     */
    public Item() {
        this.id = 0;
        this.type = "";
        this.title = "";
        this.borrowed = false;
    }
    
    /**
     * Parameterized constructor to initialize a Item object with given values
     * for id, type, title, year, borrowed.
     * 
     * @param id         The id of the item.
     * @param type       The type of the item.
     * @param title      The title of the tiem.
     * @param borrowed   The flag to check whether this item is borrowed or not.
     */
    public Item(String type, int id, String title, boolean borrowed) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.borrowed = borrowed;
    }
    
    /**
     * Method to return the id of the item.
     * 
     * @return a integer value.
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Method to return the type of the item.
     * 
     * @return a string value.
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * Method to return the title of the item.
     * 
     * @return a string value.
     */
    public String getTitle() {
        return this.title;
    }
    
    
    /**
     * Method to change the type of the item.
     * 
     * @param newType The name of new type
     */
    public void changeType(String newType) {
        this.type = newType;
    }
    
    /**
     * Method to change the title of the item.
     * 
     * @param newTitle  The name of the new title.
     */
    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }
    
    /**
     * Method to return the flag to check the item is borrowed or not.
     * 
     * @return a boolean value.
     */
    public boolean getBorrowed() {
        return this.borrowed;
    }
    
    /**
     * Method to check the availability of the item.
     * 
     * @param obj The object to compare.
     */
    public void checkItem(Object obj) {
        boolean flag = false;
        if (obj instanceof Item) {
            if (((Item) obj).getBorrowed() == flag) {
                isAvailable();
            } else {
                isUnavailable();
            }
        }
    }
    
    /**
     * Method to check the availability of the item.
     * 
     * @param obj The object to compare.
     */
    public void compareBorrow(Object obj) {
        if (obj instanceof Item) {
            if (((Item) obj).getBorrowed() == true) {
                isUnavailable();
            } else {
                this.borrowed = true;
                borrow();
            }
        }
    }
    
    /**
     * Method to return the item.
     * 
     * @param obj the object to compare.
     */
    public void compareReturn(Object obj) {
        if (obj instanceof Item) {
            if (((Item) obj).getBorrowed() == false) {
                isAvailable();
            } else {
                returnItem();
                this.borrowed = false;
            }
        }
    }
    
    /**
     * This method creates a deep copy of this object.
     * 
     * @return a deep copy of this object.
     */
    @Override
    public Item clone() {
        return Item();
    }
 

    private Item Item() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method to show how to print inside the test file.
     * 
     * @return a string value.
     */
    public String toString() {
        return this.type + "\t" + this.id + "\t" 
            + this.title + "\t" + this.borrowed;
    }

    @Override
    public void borrow() {
        // TODO Auto-generated method stub
        System.out.println("Thank you for borrowing this item.");
    }

    @Override
    public void returnItem() {
        // TODO Auto-generated method stub
        System.out.println("Thank you for returning this item.");
    }

    @Override
    public void isAvailable() {
        // TODO Auto-generated method stub
        System.out.println("This item is available to borrow.");
    }

    @Override
    public void isUnavailable() {
        // TODO Auto-generated method stub
        System.out.println("This item is unavailable to borrow.");
    }    
    
    /**
     * Method to compare the id of the Item object.
     */
    public boolean equals(Object obj) {
        boolean flag = false;
        if (obj instanceof Item) {
            Item other = (Item) obj;
            flag = getId() == (other.getId());
        }
        return flag;
    }
    
    /**
     * Method to print the information of the book
     */
    public void printInfo() {
    	System.out.println("Title: " + this.title);
    }
}
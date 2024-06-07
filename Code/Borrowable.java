/**
 * This is a simple interface that is implemented by all borrowable
 * actions.  All actions related to borrow, return and check status 
 * of the book can essentially be done by calling the borrow(), 
 * returnBook() and isAvailable() methods.  
 * 
 * @author Nhu Ngo
 *
 */
public interface Borrowable {
    /**
     * This method can be used to borrow a book that is currently
     * in the available position.  Calling this method to borrow a
     * book that is already been borrowed has no impact.
     */
    public void borrow();
    
    /**
     * This method can be used to return a book that is currently
     * unavailable.  Calling this method to return a book that is 
     * already unavailable has no impact.
     */
    public void returnItem();
    
    /**
     * This method can be used to check the availability of a book.
     * Calling this method when a book is already unavailable or 
     * available has no impact.
     */
    public void isAvailable();
    
    /**
     * This method can be used to check the unavailability of a book.
     * Calling this method when a book is already unavailable or 
     * available has no impact.
     */
    public void isUnavailable();
}

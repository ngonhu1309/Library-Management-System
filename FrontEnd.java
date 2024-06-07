import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the FrontEnd class to that is responsible 
 * for using other classes and running the project with 
 * a set of static methods.
 * 
 * @author Nhu Ngo
 */
public class FrontEnd {
    
    /**
     * A simple prompt to welcome the user.
     */
    private static final String INPUT = "Welcome to the library.\n";

    /** 
     * A simple prompt to obtain input from the user.
     */
    private static final String INPUT_PROMPT = 
             "What would you like to do [0 for menu]: ";
    
    /**
     * This is a named-constant for a string used to display a short
     * menu to the user.
     */
    private static final String MENU = 
              "    1. Work with librarians.\n"
            + "    2. Work with items.\n"
            + "    0. Show this menu\n"
            + "   -1. Quit\n";
    
    /**
     * This is a named-constant for a string used to display a short
     * menu to the user.
     */
    private static final String MENU_FOR_LIBRARIAN = 
              "    1. Print summary of things.\n"
            + "    2. To add the new librarian.\n"  
            + "    3. To remove the librarian.\n"
            + "    4. To search for the librarian based on ID.\n"
            + "    5. To search for the librarian based on the area.\n"
            + "    0. Show this menu\n"
            + "   -1. Go back to the main menu\n";
    
    /**
     * This is a named-constant for a string used to display a short
     * menu to the user.
     */
    private static final String MENU_FOR_ITEM = 
              "    1. To add items\n"
            + "    2. To remove items\n"
            + "    3. To borrow an item\n"
            + "    4. To return an item\n"
            + "    5. To check the availability of an item\n"
            + "    6. To search the item based on the ID.\n"
            + "    7. To search the item based on the type.\n"
            + "    0. Show this menu\n"
            + "   -1. Go back to the main menu\n";
    
    private static Library libra = new Library();
    
    /**
     * The  method that displays a menu and calls appropriate methods
     * in a library to perform various operations.
     * 
     * @param args The command-line arguments are not used.
     * @throws FileNotFoundException  This exception is thrown.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.printf(INPUT);
        addItems(sc, libra);
        
        do {
            System.out.printf(INPUT_PROMPT);
            final int choice = sc.nextInt(); 
            switch (choice) {
            case 0: System.out.println(MENU); 
            break;
            
            case 1: System.out.println("Welcome to the librarian menu!");
                menuForLibrarian(sc);
            break;
            
            case 2: System.out.println("Welcome to the item menu!");
                menuForItem(sc);
            break;
            
            case -1: System.out.println("Thank you for using this system!");
            return;
            
            default: System.out.println("Invalid option.");
            }
        } while (true);
    }
    
    /**
     * The method that displays a menu and calls appropriate methods
     * in a library to perform various operations related to librarians.
     * 
     * @param sc The scanner to scan the input
     * @throws FileNotFoundException  This exception is thrown.
     */
    public static void menuForLibrarian(Scanner sc) 
            throws FileNotFoundException {
        do {
            System.out.println(MENU_FOR_LIBRARIAN);
            System.out.printf(INPUT_PROMPT);
            final int choice = sc.nextInt();
            optionForLibrarian(choice, sc);
        } while (true);
    }
    
    public static void optionForLibrarian(int choice, Scanner sc) 
            throws FileNotFoundException {
        switch (choice) {
        case 0: System.out.println("\n" + MENU_FOR_LIBRARIAN); 
        break;
            
        case 1: libra.printSummary(); 
            System.out.println();
        break;
            
        case 2: libra.addLibrarian(sc); 
            System.out.println();
        break;
            
        case 3: libra.removeLibrarian(sc); 
            System.out.println();
        break;
            
        case 4: libra.findLibrarian(sc);
            System.out.println();
        break;

        case 5: libra.findLibraArea(sc);
            System.out.println();
        break;
            
        case -1: System.out.println("You have returned back to the main menu!");
            return;
        default: System.out.println("Invalid option.");
        }
    }
    
    /**
     * The method that displays a menu and calls appropriate methods
     * in a library to perform various operations related to items.
     * 
     * @param sc The scanner to scan the input
     * @throws FileNotFoundException This exception is thrown.
     */
    public static void menuForItem(Scanner sc) throws FileNotFoundException {
        do {
            System.out.println(MENU_FOR_ITEM);
            System.out.printf(INPUT_PROMPT);
            final int choice = sc.nextInt();
            optionForItem(choice, sc);
        } while (true);
    }
    
    /**
     * This method displays the options to run the Item menu.
     * 
     * @param choice      The integer represents the choice.
     * @param sc          The scanner to scan the number.
     * @throws FileNotFoundException      The exception needs to be thrown.
     */
    public static void optionForItem(int choice, Scanner sc) 
            throws FileNotFoundException {
        switch (choice) {
        case 0: System.out.println("\n" + MENU_FOR_ITEM); 
        break;
        
        case 1: libra.addIt(sc); 
            System.out.println();
        break;
        
        case 2: libra.removeIt(sc); 
            System.out.println();
        break;
        
        case 3: libra.borrowStuff(sc); 
            System.out.println();
        break;
        
        case 4: libra.returnStuff(sc); 
            System.out.println();
        break;
        
        case 5: libra.check(sc); 
            System.out.println();
        break;
        
        case 6: libra.findItem(sc); 
            System.out.println();
        break;
        
        case 7: libra.findItemType(sc); 
            System.out.println();
        break;
        
        case -1: System.out.println("You have returned back to the main menu!");
        return;
        default: System.out.println("Invalid option.");
        }
    }
    
    /**
     * Helper method enable loading things from a given text file. This method
     * is called from the main.
     * 
     * @param sc The scanner to be used to obtain path to text file.
     * @param lib The pet shop to which items are to be added.
     */
    private static void addItems(Scanner sc, Library lib) {
        System.out.print("Enter file name to add inventory: ");
        final String fileName = sc.next();
        try {
            lib.addItems(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } 
}

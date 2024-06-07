import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This is the Library class to that is responsible 
 * for using other classes and running the project with 
 * a set of static methods.
 * 
 * @author Nhu Ngo
 */
public class Library {
    
    /**
     * The items available in this library. The items are 
     * added to this list via the addItemsFromFile method.
     */
    protected ArrayList<Item> things = new ArrayList<>();
    
    /**
     * The librarians working in this library. The items are 
     * added to this list via the addLibrariansFromFile method.
     */
    protected ArrayList<Librarian> librarians = new ArrayList<>();    
    
    /**
     * A simple String that has the name of the file.
     */
    private String fileNa = "test.txt";
    
    /**
     * A simple string to announce the user has inputed the data 
     * successfully.
     */
    private String inputSuccess = "The data is inputed successfully.";
    
    /**
     * A simple string to announce the user has removed the data 
     * successfully.
     */
    private String removeSuccess = "The data is removed successfully.";
    
    /**
     * Helper method enable loading things from a given text file. This method
     * is called from the main.
     * 
     * @param fileName The name of the text file to the path to text file.
     * @throws FileNotFoundException  This one is thrown.
     */
    public void addItems(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        input.useDelimiter("\t");
        Item obj = null;
        Librarian lib = null;
        while (input.hasNext()) {
            String type = input.next();
            if (type.equals("\nlib")) {
                lib = addLibrariansFromFile(input);
                librarians.add(lib);
            } else {
                obj = addItemsFromFile(type, input);
                things.add(obj);
            }
        }
    }
    
    /**
     * Adds Librarians loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. 
     * 
     * @param input The scanner to scan the librarians.
     * @return Librarian   The librarian object.
     */
    public Librarian addLibrariansFromFile(Scanner input) {
        Librarian obj;
        String type = "lib";
        int id = input.nextInt();
        String firstName = input.next();
        String lastName = input.next();
        String area = input.next();
        
        obj = new Librarian(type, id, firstName, lastName, area);
        return obj;
    }
    
    /**
     * Adds Items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. 
     * 
     * @param type The type of the item.
     * @param input The scanner to scan the librarians.
     * @return Item The item object.
     */
    public Item addItemsFromFile(String type, Scanner input) {
        Item obj = null;
        int id = input.nextInt();
        String title = input.next();
        boolean flag = input.nextBoolean();
        String author = input.next();
        int num = input.nextInt();
        
        if (type.equals("book") || type.equals("\nbook")) {       
            obj = new Book(type, id, title, flag, author, num);
        } else {                    
            obj = new Dvd(type, id, title, flag, author, num);
        }
        return obj;
    }

    /**
     * Interface method to print a summary of the librarians in the
     * library.
     */
    public void printSummary() {
        for (Librarian lib:librarians) {
            System.out.println(lib.printSummary());
        }
    }
    
    /**
     * This method add a new librarian into the array list and update
     * the test file.
     * 
     * @param sc  The scanner sc to scan the ID.
     * @throws FileNotFoundException  This one is thrown.
     */
    public void addLibrarian(Scanner sc) throws FileNotFoundException {
        boolean flag = false;
        int id;
        do {
            System.out.print("Please input the ID of the librarian: ");
            id  = sc.nextInt();
            flag = searchLibrarian(id, true);
        } while (!flag);
        
        System.out.print("Please input the first name of the librarian: ");
        String fname = sc.next();
        
        System.out.print("Please input the last name of the librarian: ");
        String lname = sc.next();
        
        System.out.print("Please input the area of the librarian works in: ");
        String area = sc.next();
        
        String type = "lib";
        
        Librarian lib = new Librarian(type, id, fname, lname, area);
        librarians.add(lib);
        workWithFile();
        System.out.println(inputSuccess);
    }
    
    /**
     * This method use the HashMap to find the librarian object.
     * A HashMap is a data structure in computer programming 
     * that provides a way to store and retrieve data using 
     * a key-value pair mapping.
     * 
     * @param id    The id that the user inputs in.
     * @param flag  The boolean to check if this searching is for
     *     add librarian or remove librarian. If it is to add, the flag
     *     is true, and false for the remove librarian.
     * 
     * @return boolean value    This one to check if the object is 
     *     in the array list.  
     */
    public boolean searchLibrarian(int id, boolean flag) {
        Map<Integer, Librarian> map = new HashMap<>();
        for (Librarian libra : librarians) {
            map.put(libra.getId(), libra);
        }
        
        if (map.containsKey(id)) {
            if (flag == true) {
                System.out.println("Please check your input again!\n");
                return false;
            } else {
                return true;
            }
        }
        
        if (flag == true) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method helps the user to find the librarian based on
     * his or her ID.
     * 
     * @param sc      The scanner to help scan the ID.
     */
    public void findLibrarian(Scanner sc) {
        int id;
        boolean flag = false;
        Librarian lib;
        do {
            System.out.print("Please input the ID of the librarian: ");
            id = sc.nextInt();
            if (searchLibrarian(id, false) == true) {
                lib = searchLibra(id);
                flag = true;
                System.out.println(lib);
            } else {
                System.out.println("Please check your input again.\n");
            }
        } while (!flag);
    }
    
    /**
     * This method helps to find the librarian based on the area they 
     * are currently working.
     * 
     * @param sc   The scanner to scan the area the user inputs.
     */
    public void findLibraArea(Scanner sc) {
        boolean flag = false;
        String area = "";
        do {
            System.out.print("Please input the area(Book or DVD): ");
            area = sc.next();
            if (((area.toLowerCase()).equals("book")) 
                    || ((area.toLowerCase()).equals("dvd"))) {
                flag = true;
                System.out.println(searchLibraArea(area.toLowerCase()));
                break;
            } else {
                System.out.println("Please check your input again.\n");
            }
        } while (!flag);
    }
    
    /**
     * This method helps to find the librarian based on the area they 
     * are currently working.
     * 
     * @param area   The String of the area name.
     * @return Librarian     The Librarian object.
     */
    public Librarian searchLibraArea(String area) {
        Map<String, Librarian> map = new HashMap<>();
        for (Librarian libra : librarians) {
            map.put(libra.getArea(), libra);
        }
        
        Librarian lib = null;
        if (map.containsKey(area)) {
            return lib = map.get(area);
        }
        return lib;
    }
    
    /**
     * This method helps to find the type of the item.
     * 
     * @param sc     The scanner helps to scan the item type.
     */
    public void findItemType(Scanner sc) {
        boolean flag = false;
        String area = "";
        do {
            System.out.print("Please input the area(Book or DVD): ");
            area = sc.next();
            if (area.toLowerCase().equals("book") 
                    || area.toLowerCase().equals("dvd")) {
                flag = true;
                break;
            } else {
                System.out.println("Please check your input again.\n");
            }
        } while (flag);
        System.out.println(searchItemType(area.toLowerCase()));
    }
    
    /**
     * This method helps to find the item based on the type.
     * 
     * @param type        The type of the item
     * @return Item
     */
    public Item searchItemType(String type) {
        Map<String, Item> map = new HashMap<>();
        for (Item it : things) {
            map.put(it.getType(), it);
        }
        
        Item it = null;
        if (map.containsKey(type)) {
            return it = map.get(type);
        }
        return it;
    }
    
    /**
     * This method helps to find the item based on its ID.
     * 
     * @param sc    The scanner to scan the input.
     */
    public void findItem(Scanner sc) {
        int id;
        boolean flag = false;
        Item it;
        do {
            System.out.print("Please input the ID of the item: ");
            id = sc.nextInt();
            if (searchItem(id, false) == true) {
                it = searchIt(id);
                flag = true;
                System.out.println(it);
            } else {
                System.out.println("Please check your input again.\n");
            }
        } while (!flag);
    }
    
    /**
     * This method add a new item object into the array list and update
     * the test file.
     * 
     * @param sc   The scanner to scan the things user input.
     * @throws FileNotFoundException  This one is thrown.
     */
    public void addIt(Scanner sc) throws FileNotFoundException {
        boolean flag = false;
        int id; 
        
        System.out.print("Please input the type of the item: ");
        String type = sc.next();
        String type2 = "\n" + type;
        
        do {            
            System.out.print("Please input the ID of the item: ");
            id  = sc.nextInt();
            flag = searchItem(id, true);
        } while (!flag);
        sc.nextLine();
        
        System.out.print("Please input the title of the item: ");
        String title = sc.nextLine();
        
        System.out.print("Please input the author/publisher of the item: ");
        String author = sc.nextLine();
        
        System.out.print("Please input the version/duration of the item: ");
        int number = sc.nextInt();
        
        boolean borrowed = false;
        createItem(type, type2, id, title, borrowed, author, number);
         
        workWithFile();
        System.out.println(inputSuccess);
    }
    
    /**
     * This method helps create an object based on the information provided.
     * 
     * @param type      The object of the item.
     * @param type2     The type of the item.
     * @param id        The id of the item.
     * @param title     The title of the item.
     * @param borrowed  The flag to see if this item is borrowed or not.
     * @param author    The author of the item.
     * @param number    The number of the item.
     */
    public void createItem(String type, String type2, int id, String title,
            boolean borrowed, String author, int number) {
        if (type.equals("book")) {
            Book it = new Book(type2, id, title, borrowed, author, number);
            things.add(it);
        } else {
            Dvd it = new Dvd(type2, id, title, borrowed, author, number);
            things.add(it);
        } 
    }
    
    /**
     * This method use the HashMap to find the item object.
     * A HashMap is a data structure in computer programming 
     * that provides a way to store and retrieve data using 
     * a key-value pair mapping.
     * 
     * @param id    The id that the user inputs in.
     * @param flag  The boolean to check if this searching is for
     *     add librarian or remove librarian. If it is to add, the flag
     *     is true, and false for the remove librarian.
     * 
     * @return boolean value    This one to check if the object is 
     *     in the array list.  
     */
    public boolean searchItem(int id, boolean flag) {
        Map<Integer, Item> map = new HashMap<>();
        for (Item it : things) {
            map.put(it.getId(), it);
        }
        
        if (map.containsKey(id)) {
            if (flag == true) {
                System.out.println("Please check your input again!\n");
                return false;
            } else {
                return true;
            }
        }
        
        if (flag == true) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method use the HashMap to find the librarian object.
     * A HashMap is a data structure in computer programming 
     * that provides a way to store and retrieve data using 
     * a key-value pair mapping.
     * 
     * @param id    The id that the user inputs in.
     * 
     * @return Librarian  The librarian object that the user needs
     *     to find
     */
    public Librarian searchLibra(int id) {
        Map<Integer, Librarian> map = new HashMap<>();
        for (Librarian libra : librarians) {
            map.put(libra.getId(), libra);
        }
        
        Librarian lib = null;
        if (map.containsKey(id)) {
            return lib = map.get(id);
        } else {
            System.out.println("Please check your input again!\n");
            return lib;
        }
    }
    
    /**
     * This method remove a new librarian into the array list and update
     * the test file.
     * 
     * @param sc  The scanner to scan the input.
     * @throws FileNotFoundException  This exception is thrown.
     */
    public void removeLibrarian(Scanner sc) throws FileNotFoundException {
        int id;
        boolean flag = false;
        Librarian lib;
        do {
            System.out.print("Please input the ID of the librarian: ");
            id = sc.nextInt();
            if (searchLibrarian(id, false) == true) {
                lib = searchLibra(id);
                librarians.remove(lib);
                workWithFile();
                flag = true;
                System.out.println(removeSuccess);
            }
        } while (!flag);
    }
    
    /**
     * This method use the HashMap to find the Item object.
     * A HashMap is a data structure in computer programming 
     * that provides a way to store and retrieve data using 
     * a key-value pair mapping.
     * 
     * @param id    The id that the user inputs in.
     * 
     * @return Item  The Item object that the user needs
     *     to find
     */
    public Item searchIt(int id) {
        Map<Integer, Item> map = new HashMap<>();
        for (Item it : things) {
            map.put(it.getId(), it);
        }
        
        Item it = null;
        if (map.containsKey(id)) {
            return it = map.get(id);
        } else {
            System.out.println("Please check your input again!\n");
            return it;
        }
    }
    
    /**
     * This method remove a new item into the array list and update
     * the test file.
     * 
     * @param sc  The scanner to scan the input.
     * @throws FileNotFoundException   This exception is thrown.
     */
    public void removeIt(Scanner sc) throws FileNotFoundException {
        int id;
        boolean flag = false;
        do {
            System.out.print("Please input the ID of the item: ");
            id = sc.nextInt();
            for (Item it:things) {
                if (it.getId() == id) {
                    int index = things.indexOf(it);
                    things.remove(index);
                    flag = true;
                    workWithFile();
                    System.out.println(removeSuccess);
                    break;
                }
            }
            if (flag == false) {
                System.out.println("This ID does not exist.\n");
                System.out.println();
            }
        } while (!flag);
    }
       
    /**
     * This method check to see if the user can borrow this item.
     * If it is not, it will print out the isUnavailable() method
     * in the interface. If they can borrow, it will update the 
     * information in the test file.
     * 
     * @param sc  The scanner sc to scan the input of the ID.
     * @throws FileNotFoundException This one is thrown.
     */
    public void borrowStuff(Scanner sc) throws FileNotFoundException {
        System.out.print("Please input the ID of the item: ");
        int id = sc.nextInt();
        Item it = searchIt(id);
        it.compareBorrow(it);
        if (it.getBorrowed() == true) {
            workWithFile();
        }
         
    }
    
    /**
     * This method check to see if the user can return this item.
     * If it is not, it will print out the isAvailable() method
     * in the interface. If they can return, it will update the 
     * information in the test file.
     * 
     * @param sc  The scanner to scan the input of the ID.
     * @throws FileNotFoundException   This one is thrown.
     */
    public void returnStuff(Scanner sc) throws FileNotFoundException {
        System.out.print("Please input the ID of the item: ");
        int id = sc.nextInt();
        Item it = searchIt(id);
        it.compareReturn(it);
        if (it.getBorrowed() == false) {
            workWithFile();
        }
    }
    
    /**
     * This method check to see if  this item is available or
     * unavailable to borrow.
     * 
     * @param sc The scanner sc to scan the input of the ID.
     */
    public void check(Scanner sc) {
        System.out.print("Please input the ID of the item: ");
        int id = sc.nextInt();
        Item it = searchIt(id);
        it.checkItem(it);
    }
    
    /**
     * This method works with PrintWriter and test file to update
     * the information when it is called.
     * 
     * @throws FileNotFoundException    This one throws.
     */
    public void workWithFile() throws FileNotFoundException {
        try {
            // Create a PrintWriter to write to a text file
            PrintWriter writer = new PrintWriter(new File(fileNa));

            // Write the objects to the file
            for (Item it:things) {
                writer.print(it);
            }
            
            for (Librarian lib:librarians) {
                writer.print("\n" + lib);
            }

            // Close the file
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

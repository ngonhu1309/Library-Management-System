# Library-Management-System

## Project Overview:
The library management system project is a software program created to assist libraries in managing their book collections and loan procedures. It offers librarians a user-friendly interface for managing and keeping track of both the books that are on hand in the library and those that have been checked out by customers.

## Goals:

1. Streamline library operations: The goal of the library management system is to make daily operations more efficient. This is accomplished by automating several the manual book management procedures, including book borrowing, returns, and inventory management. The system lowers errors and saves time by giving librarians a productive way to manage their books and customers.

2. Improve customer experience: By offering a straightforward and user-friendly interface for borrowing and returning books, the library management system is intended to enhance the patron experience. Customers can quickly search for books, put holds on them, and check the status of their accounts with the use of this technology.
   
3. Maintain accurate records: The library management system maintains precise records of every book, every user, and every borrowing transaction. This makes it easier for librarians to keep track of the volumes that are available.

4. Increase library efficiency: The library management system improves library efficiency by automating many of the manual procedures involved in book management. With this system in place, librarians may devote more time to other crucial library jobs like book recommendations and patron outreach and less time to administrative duties.The library management system is, in general, a crucial instrument for contemporary libraries. It makes managing books and users more effective for librarians, improving the borrowing experience for users. Libraries may boost their overall effectiveness, cut down on errors, and save time by utilizing this method.

## Requirements and Design

![image](https://github.com/ngonhu1309/Library-Management-System/assets/135569353/a33bc54d-c4b4-4e97-823b-c1c9d5c1e6f3)

1. Item class
  * This class is a superclass.
  * It has attributes such as type, title, year and whether it is borrowed or not.
  * It provides a method to get the type, title, year, whether it is borrowed or not, etc.

2. Book class:
  * This class represents a book in the library.
  * This class is a child class and inherited from Item class.
  * It has more attributes such as author and version.
  * It provides a method to get the author’s name and version.

3. DVD class:
  * This class represents a book in the library.
  * This class is a child class and inherited from Item class.
  * It has more attributes such as author and version.
  * It provides a method to get the author’s name and version.

4. Librarian class:
  * This class represents a librarian in the library.
  * It also has the area, such as books or DVD, that the librarian is responsible to.
    
5. Library class:
  * This class represents the library itself, which contains multiple books.
  * It has an arrayList of Item objects and an arrayList of librarian objects.
  * It provides methods to add or remove a book, etc.

6. Borrowable interface class:
  * The Borrowable interface defines the methods that a book object needs to implement in order to be able to be borrowed and returned.
  * The Borrowable interface has three methods: borrow(), return(), and isAvailable().
      * The borrow() method is used to borrow a book by setting the book's isBorrowed flag to true.
      * The returnBook() method is used to return the book by setting the isBorrowed flag to false.
      * The isAvailable() check whether the book is available to borrow.
  * Any class that implements the Borrowable interface will have to provide an implementation for both the borrow(), returnBook() and isAvailable() methods.

## Text File

I am planning to create a text file that contains both the information of items and information of librarians. That means there will be some lines that have 7 data and there will be some lines that only have 4 data. The data will be separated by a tab. For example:

<img width="728" alt="image" src="https://github.com/ngonhu1309/Library-Management-System/assets/135569353/73f100b2-da75-4f9d-aea7-cc066c2ab412">

## Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request with improvements or bug fixes.
## Credits
Author: Nora Ngo

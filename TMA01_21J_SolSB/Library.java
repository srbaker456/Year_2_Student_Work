// Import of ArrayList and Iterator required for this class.
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class holds information on a library containing Books.
 * @author (Steven Baker)
 * @version (Start 30/11/2021)
 */
 public class Library
{
    // Q2 Part b.
    // Here are the two private fields.
    // The books field holds the Book objects in the library.
     private ArrayList<Book> books;
    // The name field holds the name of the library.
     private String name;

    /**
     * Q2 Part c
     * Constructor for objects of class Library.
     */
    public Library(String aName)
    {
        // initialisation of instance variables.
        // The name entered when the object is created becomes the library's name.
        name = aName;
        // the books field is initialised 
        books = new ArrayList<>();
    }

    /**
     * Q2 Part d i
     * This method enters a new book into the library.
     * 
     */
    public void addBook(String author, String title, String id)
    {
        // The three public fields of the book are added here, using the add method.
        books.add(new Book(author, title, id));
    }
    
    /**
     * Q2 Part d ii
     * This method calculates the fine for a book that is returned late,
     * based on its price and how late the return is.
     */
    public double calculateFine(double bookPrice, int daysLate)
    {
        // The local variable is initialised .
        double fine = 0.0;
        // The fine is calculated as per the discription.
        fine = (bookPrice / 100) * (2 * daysLate);
        // The calculated fine value is returned.
        return fine;
    }
    
    /**
     * Q2 Part d iii
     * This method seaches for the title of the book,
     * from a given string.
     */
    public ArrayList<Book> getMatchingBooks(String searchedBook)
    {
        // A new ArrayList is initialised to hold the books with a matching title.
        ArrayList<Book> matchingBooks = new ArrayList<Book>();
        // This loop is used to check each book in the library.
        for (Book book : books) {
              // If the title of the current book in the loop matches the given parameter...
              if(book.getTitle().equals(searchedBook)) {
                  // ...Then the match is then added to the new local array list.
                  matchingBooks.add(book);
              }
           }
        // All the books in this new ArrayList are returned.   
        return matchingBooks;
    }
    
    /**
     * Q2 Part d iv,
     * This method returns the loan status of a book.
     */
    public boolean isAvailable(Book bookChecked)
    {
        // The boolean return value is initialised .
        boolean availability  = false;
        // This loop is used to check each book in the library.
        for (Book book : books) {
            // If the title of the current book in the loop matches the title of the book given in the parameter...  
            if(book.getTitle().equals(bookChecked.getTitle()) && !bookChecked.isOnLoan()) {
                  // ...The boolean return value is set to true.
                  availability  = true;
              }
           }
        //  The resulting boolean is then returned. 
        return availability ;
    }
    
    /**
     * Q2 Part d v,
     * This method lists all the books in the library.
     */
    public void listAllBooks()
    {
        // This loop is used to check each book in the library.
        for (Book book : books) {
            // This print statement then uses the toString() method of the Book class.
            System.out.println(book.toString());
        }
    }
    
    /**
     * Q2 Part d vi,
     * This method sets the specified book to be on loan.
     */
     public void loanBook(Book bookToLoan)
    {
        // This loop is used to check each book in the library.
        for (Book book : books) {
            // If the ID of the current book in the loop matches the ID of the book given in the parameter...
            if(book.getId().equals(bookToLoan.getId())) {
                  // ...Then this book's onLoan value is set to true using the setOnLoan method of the Book class.
                  bookToLoan.setOnLoan(true);
              }
           }
    }
    
    /**
     * Q1 Part d vii,
     * This method sets the specified book to be on loan.
     */
     public void removeBook(Book bookToRemove)
    {
        // The boolean value is initalised that is used to impliment an if statement if there is no book to be found.
        boolean removedBook = false;
        // An iterator is set up so that the collection can be modified.
        Iterator<Book> it = books.iterator();
        // This loop is used to check each book in the library.
        while(it.hasNext()) {
             Book iter = it.next();;
             // If the ID of the current book in the loop matches the ID of the book given in the parameter...
             if(iter.getId().equals(bookToRemove.getId())) {
                  //...Then this book is removed from the books ArrayList.
                  it.remove();
                  // The control value is set to true.
                  removedBook = true;
             }
        }
        // If the ID of the current book in the loop does not match the ID of the book given in the parameter...
        if(!removedBook) {
                  // This print statement then gives the message "book not found".
                  System.out.println("book not found");
              }
    }
    
}

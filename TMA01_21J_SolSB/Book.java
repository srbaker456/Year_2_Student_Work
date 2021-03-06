
/**
 * This class holds information on a book to be used by other
 * classes, such as the library class.
 * @author (Steven Baker)
 * @version (Start 14/11/2021)
 */
public class Book
{
    // Q1 Part b. The fields used in this class.
    private String author;
    private String title;
    private String id;
    private boolean onLoan;
    
    /**
     * Q1 Part c 
     * This is the constructor for objects 
     * of class Book with the modifier and header. It links the author, title and id of
     * the class to variables and initialises the onLoan variable to false.
     */
    public Book(String anAuthor, String aTitle, String anId)
    {
        // initialisation of the instance variables.
        author = anAuthor;
        title = aTitle;
        id = anId;
        onLoan = false;
      
    }

    /**
     * Q1 Part d,
     * This method returns the author of a book.
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Q1 Part d,
     * This method returns the title of a book.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Q1 Part d,
     * This method returns the ID of a book.
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Q1 Part d,
     * This method returns the loan status of a book.
     */
    public boolean isOnLoan()
    {
        return onLoan;
    }
    
    /**
     * Q1 Part d,
     * This method sets the loan status of a book to true after it has been taken out.
     */
    public void setOnLoan(boolean onLoanSet)
    {
        onLoan = onLoanSet;
    }
    
    /**
     * Q1 Part e,
     * This method returns a string that describes the book.
     */
     public String toString()
    {
        // A local variable is initalised that is used to return the desired statement.
        String availability = "(available)";
        // If the boolean variable onLoan is true...
        if (onLoan) {
            // Then the local variable is set to use the appropriate string.
            availability = "(on loan)";
        }
        // The string is then composed bellow out of the fields of the book.
        return ("Title: " + title + ", Author: " + author + " " + availability);
    }
    
    /**
     * Q1 Part f,
     * This method returns a boolean concerning if the book
     * has a valid ID.
     */
    public boolean verifyId()
    {
        // The boolean value is initalised that is used to impliment an if statement if there is no book to be found.
        boolean isValidID = false;
        // The local variable, total, is initialised to be used to check if the id is valid as per instruction.
        int total = 0;
        // If the id is not seven characters in length...
        if (id.length() != 7 ) {
            // ...Then the id is not valid.
            isValidID = false;
        }
        // Otherwise, if it is seven characters in length, the rest of the algorithm is used below.
        else {
            // This for loop uses an index to select each character of the id. 
            // An index is initialised to zero and if this value is less than the length of the string, 
            // it is then increased by 1 for each loop.
            for(int i=0; i<=id.length()-1; i++) {
	        // This selects the character  at the position in the loop.
                char ch = (id.charAt(i));
                // The division remainder is then calculated...
	        int eval = (ch % 10);
	        // ...and added to the total.
	        total = total + eval;
            }
            // The division remainder of the total is then calculated.
            int idResult = (total % 7);
            // If the resulting remainder equals zero...
            if (idResult == 0 ) {
                // ...Then the ID is valid.
                isValidID = true;
        }
        }
        //  The resulting boolean is then returned.
        return isValidID;
        }    
}
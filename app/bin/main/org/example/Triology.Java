
/*
 * This file is unrelated to the assignment, but you can used this as a reference.
 */
public class Trilogy {
    // Fields
    private String book1;
    private String book2;
    private String book3;
    private String author;

    // Constructor
    public Trilogy(String book1, String book2, String book3, String author) {
        this.book1 = book1;
        this.book2 = book2;
        this.book3 = book3;
        this.author = author;
    }

    // Method to display all books in the trilogy
    public void displayTrilogy() {
        System.out.println("Trilogy by " + author + ":");
        System.out.println("1. " + book1);
        System.out.println("2. " + book2);
        System.out.println("3. " + book3);
    }

    // Method to get a specific book by number (1–3)
    public String getBook(int number) {
        switch (number) {
            case 1:
                return book1;
            case 2:
                return book2;
            case 3:
                return book3;
            default:
                return "Invalid book number (choose 1-3)";
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create a Trilogy object
        Trilogy lotr = new Trilogy(
            "The Fellowship of the Ring",
            "The Two Towers",
            "The Return of the King",
            "J.R.R. Tolkien"
        );

        // Display the full trilogy
        lotr.displayTrilogy();

        // Get and print the second book
        String secondBook = lotr.getBook(2);
        System.out.println("Second book: " + secondBook);
    }
}

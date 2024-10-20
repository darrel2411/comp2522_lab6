import java.util.List;

public class Main {

    /**
     * The main method that demonstrates the functionality of the {@code BookStore} class.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
       final BookStore<Literature> bookstore;
       final Literature comic;
       final Literature Novel;
       final Literature magazine;


       bookstore = new BookStore<>("Heaven");
       comic     = new ComicBook("Batman 1990");
       magazine  = new Magazine("Vogue");
       Novel     = new Novel("The Adventures of Augie March",
                             "Saul Bellow", 1953);


       // Adding items to the bookstore list
        bookstore.addItem(comic);
        bookstore.addItem(magazine);
        bookstore.addItem(Novel);

        bookstore.printItems();


    }
}

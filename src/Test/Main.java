import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * It will create a Bookstore and test the methods
 * inside the class.
 *
 * @author Manases
 * @author Darrel
 * @version 1.0
 */
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
       final List<Literature> items;



       bookstore = new BookStore<>("Heaven");
       comic     = new ComicBook("Batman 1990");
       magazine  = new Magazine("Vogue");
       Novel     = new Novel("The Adventures of Augie March",
                             "Saul Bellow", 1953);
       items     = new ArrayList<>();


       // Adding items to the bookstore list
        bookstore.addItem(Novel);
        bookstore.addItem(comic);
        bookstore.addItem(magazine);


        items.add(comic);
        items.add(magazine);
        items.add(Novel);

        bookstore.printItems();


        // Nested classes
        final BookStore.NovelStatistics stats;
        final BookStore.BookStoreInfo bookStoreInfo;

        stats = bookstore.new NovelStatistics();
        bookStoreInfo = new BookStore.BookStoreInfo();

        bookStoreInfo.displayInfo("Hello", 32);

        System.out.println("The average length of the titles is: " + stats.averageTitleLength());
        System.out.println();

        System.out.println("Sorting");


        items.sort(new Comparator<Literature>(){
            /**
             * It compares two literature objects
             * and base on the length of the title
             * @param o1 as a Literature object
             * @param o2 as a Literature object
             * @return 1 = o1 greater than o2
         *            -1 = o2 greater than o1
         *             0 = o1 and o2 are equal
             */
            @Override
            public int compare(Literature o1, Literature o2){
                final int lengthTitle1;
                final int lengthTitle2;

                lengthTitle1 = o1.getTitle().length();
                lengthTitle2 = o2.getTitle().length();

                return Integer.compare(lengthTitle1, lengthTitle2);
            }
        });

        // It will print the objects in the list
        for(final Literature item : items){
            System.out.println(item.getTitle());
        }
    }
}

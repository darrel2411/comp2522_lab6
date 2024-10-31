import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Represent a BookStore class.
 * @author Darrel Tapilaha
 * @author Manases Villalobos
 * @version 1.0
 */
public class BookStore <T extends Literature>
{
    private final String name;
    private final List<T> items;

    private static final int NOTHING = 0;

    /**
     * Constructs a {@code BookStore} object with the specified name.
     * Initializes an empty list of novels and adds a few sample novels.
     *
     * @param name the name of the bookstore
     * @throws IllegalArgumentException if the provided name is blank or empty
     */
    public BookStore(final String name)
    {
        validateName(name);

        this.name = name;
        this.items = new ArrayList<>();


    }

    /*
     * Validates the bookstore's name.
     * Throws an IllegalArgumentException if the name is empty or blank.
     */
    private void validateName(final String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    /*
     * Throw new IllegalArgumentException if novel is empty or equals to null value.
     */
    private void validateNovelList(final List<T> novels) {
        if (novels == null || novels.isEmpty()) {
            throw new IllegalArgumentException("Novel list is empty!");
        }
    }

    /**
     * It adds different literature types
     * to the items list.
     * @param item generic type so it can accept
     *             a novel, comic book, or magazine.
     */
    public void addItem(final T item) {
        items.add(item);
    }

    /**
     * prints al the items in the list of items.
     */
    public void printItems(){
        int counter = NOTHING;

        for (final T item : items) {
            counter++;
            System.out.println("#" + counter);
            System.out.println(item.getTitle());
            System.out.println();
        }
    }

    /**
     * Returns the name of the bookstore.
     *
     * @return the name of the bookstore as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Prints all novel titles in the collection in uppercase.
     */
    public void printAllTitles() {
        validateNovelList(this.items);

        for (final T n : this.items) {
            final String title;
            title = n.getTitle().toUpperCase();
            System.out.println(title);
        }
    }

    /**
     * Prints the titles of novels that contain the specified word (case-insensitive) in their title.
     *
     * @param word the word to search for in the title
     */
    public void printBookTitle(final String word) {
        validateNovelList(this.items);

        items.forEach(book -> {
            if(book.getTitle().contains(word)) {
                System.out.println(book.getTitle());
            }

        });
    }

    /**
     * Prints all novel titles in the collection in alphabetical order.
     */
    public void printTitlesInAlphaOrder() {
        final List<String> titles;

        titles = new ArrayList<>();

        items.forEach(book -> {
            titles.add(book.getTitle());
        });

        titles.sort(String::compareToIgnoreCase);

        titles.forEach(System.out::println);

    }

    /**
     * It checks it the type of the item is a novel
     * and them added it to the list.
     * @param novelCollection as a List
     */
    public void addNovelsToCollection(final List<? super Novel> novelCollection)
    {
        for(final T item: this.items) {
            if(item instanceof Novel){
                novelCollection.add((Novel)item);
            }
        }
    }

    /**
     * Prints the novel with the longest title in the collection.
     */
    public void getLongest() {
        // need to re-assign longest title if found the new longest title
        T longestTitle;
        longestTitle = null;

        // throw error if list of novels is null
        validateNovelList(this.items);

        for (final T n : this.items) {
            if(longestTitle == null){
                longestTitle = n;
            } else {
                final int longestTitleLength;
                final int currentTitleLength;

                longestTitleLength = longestTitle.getTitle().length();
                currentTitleLength = n.getTitle().length();

                if (longestTitleLength < currentTitleLength) {
                    longestTitle = n;
                }
            }
        }

        if(longestTitle != null){
            System.out.println(longestTitle.toString());
        }

    }

    /**
     * Returns the number of novels that contain the specified word in their title.
     *
     * @param word the word to search for
     * @return the number of novels that contain the specified word
     */
    public int howManyBooksContain(final String word) {
        // need to re-assign the counter
        int counter;
        final String search;

        counter = NOTHING;
        search = word.toLowerCase();

        validateNovelList(this.items);

        for (final T n : items) {
            final String title;

            title = n.getTitle().toLowerCase();

            if (title.contains(search)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns a list of novels whose titles have a length greater than or equal to the specified length.
     *
     * @param minTitleLength the length of the title to match
     * @return a list of novels with titles of the specified length
     */
    public List<T> getBooksThisLength(final int minTitleLength) {
        final List<T> novelsWithSpecificLength;

        novelsWithSpecificLength = new ArrayList<>();

        validateNovelList(this.items);

        for (final T n : this.items) {
            final int thisTitleLength;

            thisTitleLength = n.getTitle().length();

            if (thisTitleLength >= minTitleLength) {
                novelsWithSpecificLength.add(n);
            }
        }
        return novelsWithSpecificLength;
    }

    /**
     * It has a method that displays the name of the
     * bookstore and number of books.
     */
    public static class BookStoreInfo{

        public void displayInfo(final String storeName,
                                final int itemCount)
        {
            System.out.println("Bookstore: " + storeName + "\n" +
                               "Items: " + itemCount + "\n");
        }
    }

    /**
     * Provides a statistical analysis, such as calculating
     * the average title length of the book type or find the most common
     * publication year.
     */
    public class NovelStatistics{

        public double averageTitleLength(){
            int totalLength = NOTHING;
            for(final T item: items){
                totalLength += item.getTitle().length();
            }

            return (double) totalLength / items.size();
        }
    }
}

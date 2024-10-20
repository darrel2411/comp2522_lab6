/**
 * It represents a comic book extending from the
 * abstract class literature
 *
 * @author Manases Villalobs
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class ComicBook extends Literature{
    private final String title;

    /**
     * Creates a comic book objects.
     * @param title as a string representing the title
     *              of the comic book.
     */
    public ComicBook(final String title)
    {
        validateTitle(title);

        this.title = title;
    }


    /*
     * Validates the title of the comic and
     * throws an Illegal Argument Exception if
     * the name is empty or blank or null
     * @param title
     */
    private void validateTitle(final String title) {
        if(title == null || title.isBlank() ||
                title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank or empty");
        }
    }

    /**
     * Returns the title of the comic book.
     * @return title as a string
     */
    @Override
    public String getTitle() {
        return title;
    }
}

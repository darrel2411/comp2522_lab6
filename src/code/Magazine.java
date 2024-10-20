/**
 * Represents a magazine extending from
 * the class literature.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */
public class Magazine extends Literature{
    private String title;

    /**
     * Creates a magazine object.
     * @param title as the title of magazine
     *              as a string.
     */
    public Magazine(final String title){
        validateTitle(title);
        this.title = title;
    }

    /*
     * Validates the title of the magazine and throws an
     * IllegalArgumentException in case the title is
     * blank or empty or null.
     * @param title as a String
     */
    private void validateTitle(final String title) {
        if(title == null || title.isBlank() ||
            title.isEmpty())
        {
            throw new IllegalArgumentException("Title cannot be blank or empty");
        }
    }

    /**
     * Return the title of the magazine.
     * @return title as a string.
     */
    @Override
    public String getTitle() {
        return title;
    }
}

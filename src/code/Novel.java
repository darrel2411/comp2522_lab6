/**
 * Represents a novel.
 *
 * @author Manases Villalobos
 * @author Darrel Tapilaha
 * @version 1.0
 */

public class Novel extends Literature{
    private final String title;
    private final String authorName;
    private final int yearPublished;

    /**
     * It creates an object representing
     * a novel.
     * @param title represents the title of the novel as a string
     * @param authorName as string representing the name of the author
     * @param yearPublished as an int representing the year it was published
     */
    public Novel(final String title,
                 final String authorName,
                 final int yearPublished)
    {
        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }


    /**
     * Accessor for the title of the novel.
     * @return title
     */
    @Override
    public String getTitle() {
        return title;
    }


    /**
     * Accessor for the author's name.
     * @return
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Accessors for the year published
     * @return
     */
    public int getYearPublished() {
        return yearPublished;
    }


    /**
     * Creates a sentences with the information of the novel.
     * @return details as a String.
     */
    @Override
    public String toString(){
        return "Title: " + title + "\n" +
                "Author: " + authorName + "\n" +
                "Year published: " + yearPublished;
    }

}

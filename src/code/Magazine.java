public class Magazine extends Literature{
    private String title;
    public Magazine(final String title){
        validateTitle(title);
        this.title = title;
    }

    private void validateTitle(final String title) {
        if(title.isBlank() || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank or empty");
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}

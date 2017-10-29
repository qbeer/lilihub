public class Book {

    private String isbn;
    private String title;
    private int authorId;

    public Book() {
    }

    public Book(String isbn, String title, int authorId) {
        this.isbn = isbn;
        this.title = title;
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString(){
        return String.format("Book[Title = %s, Author's id = %d, ISBN = %s]",title,authorId,isbn);
    }

}

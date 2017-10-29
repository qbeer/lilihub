public class Main {

    public static void main(String[] args) {

        Book b1 = new Book("ISBN-9789989153822", "Norwegian Wood", 1);
        Book b2 = new Book("ISBN-9780571315031", "The Buried Giant", 2);
        Author a1 = new Author(1, "Haruki", "Murakami", 1949);
        Author a2 = new Author(2, "Kazuo", "Ishiguro", 1954);

        try {
            BookServiceImpl.getInstance("/home/qbeer666/Bothor").addBook(b1);
            BookServiceImpl.getInstance("/home/qbeer666/Bothor").addBook(b2);
            BookServiceImpl.getInstance("/home/qbeer666/Bothor").getBookByIsbn("dummy-isbn");
            AuthorServiceImpl.getInstance("/home/qbeer666/Bothor").addAuthor(a1);
            AuthorServiceImpl.getInstance("/home/qbeer666/Bothor").addAuthor(a2);
            Author[] authors = AuthorServiceImpl.getInstance("/home/qbeer666/Bothor").getAllAuthors();
            System.out.println("*******ALL AUTHORS:*************");
            for(Author au : authors){
                System.out.println(au);
            }
            System.out.println("********************************");
            Author author = AuthorServiceImpl.getInstance("/home/qbeer666/Bothor").getAuthorById(1);
            System.out.println("*******AUTHOR BY ID::1**********");
            System.out.println(author);
            System.out.println("********************************");
            System.out.println("BOOK BY ISBN::ISBN-9789989153822");
            Book book = BookServiceImpl.getInstance("/home/qbeer666/Bothor").getBookByIsbn("ISBN-9789989153822");
            System.out.println(book);
            System.out.println("********************************");
        }catch (InvalidIdException e){
                System.out.println("Invalid AtuhorId");
        } catch (InvalidIsbnException e) {
            System.out.println("Invalid BookIsbn");
        } catch (NoAuthorByIdException e) {
            System.out.println("NoAuthorById");
        }catch (NoBookByIsbnException e){
                System.out.println("NoBookByIsbn");
        }
    }

}

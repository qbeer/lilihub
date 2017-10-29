import java.io.*;

public class FileBookStore implements BookStore {

    private String srcDir;
    private static FileBookStore INSTANCE;

    private FileBookStore(String srcDir){
        this.srcDir = srcDir;
        File newSrcDir = new File(srcDir+"/books");
        newSrcDir.mkdir();
    }

    public static FileBookStore getInstance(String srcDir) {
        if(INSTANCE == null){
            INSTANCE = new FileBookStore(srcDir);
        }
        return INSTANCE;
    }

    @Override
    public Book getBookByIsbn(String isbn) throws NoBookByIsbnException {
        try {
            FileReader fileReader = new FileReader(srcDir + "/books/" + isbn + "/book.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String title;
            int authorId;
            try {
                title = bufferedReader.readLine();
                authorId = Integer.parseInt(bufferedReader.readLine());
                bufferedReader.close();
                return new Book(isbn,title,authorId);
            }catch (IOException e){
                System.out.println("IOException - FileBookStore getBookByIsbn");
            }
        }catch (FileNotFoundException e){
            throw new NoBookByIsbnException("No book by "+isbn+" yet.");
        }
        return null;
    }

    @Override
    public void addBook(Book b) throws InvalidIsbnException{
        try{
            FileReader fileReader = new FileReader(srcDir + "/books/" + b.getIsbn() + "/book.txt");
            throw new InvalidIsbnException("Book is already in the database.");
        }catch (FileNotFoundException e){
            File newDir = new File(srcDir+"/books/"+b.getIsbn());
            newDir.mkdir();
            try {
                FileWriter fileWriter = new FileWriter(srcDir + "/books/" + b.getIsbn() + "/book.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(b.getTitle());
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(b.getAuthorId()));
                bufferedWriter.close();
            }catch (IOException e2){
                System.out.println("IOException - FileBookStore addBook");
            }
        }
    }
}

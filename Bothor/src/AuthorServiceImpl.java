import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements AuthorService{

    private String srcDir;
    private static AuthorServiceImpl INSTANCE;

    private AuthorServiceImpl(String srcDir){
        this.srcDir = srcDir;
    }

    public static AuthorServiceImpl getInstance(String srcDir){
        if(INSTANCE == null){
            INSTANCE = new AuthorServiceImpl(srcDir);
        }
        return INSTANCE;
    }

    @Override
    public Author[] getAllAuthors() throws NoAuthorByIdException {
        List<Author> authors = new ArrayList<>();
        File[] files = new File(srcDir+"/authors").listFiles();
        for(File file : files){
            if(file.isDirectory()){
                authors.add(FileAuthorStore.getInstance(srcDir).getAuthorById(Integer.parseInt(file.getName())));
            }
        }
        Author[] authorArr = new Author[authors.size()];
        authorArr = authors.toArray(authorArr);
        return authorArr;
    }

    @Override
    public void addAuthor(Author a) throws InvalidIdException {
        FileAuthorStore.getInstance(srcDir).addAuthor(a);
    }

    @Override
    public Author getAuthorById(int id) throws NoAuthorByIdException {
        return FileAuthorStore.getInstance(srcDir).getAuthorById(id);
    }

}

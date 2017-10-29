package Services;

import Exceptions.InvalidIdException;
import Exceptions.NoAuthorByIdException;
import Store.Author;
import Store.AuthorStore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements AuthorService{

    private final String srcDir;
    private final AuthorStore store;


    public AuthorServiceImpl(String srcDir){
        this.srcDir = srcDir;
        store = new FileAuthorStore(srcDir);
    }

    @Override
    public Author[] getAllAuthors() throws NoAuthorByIdException {
        List<Author> authors = new ArrayList<>();
        File[] files = new File(srcDir+"/authors").listFiles();
        for(File file : files){
            if(file.isDirectory()){
                authors.add(store.getAuthorById(Integer.parseInt(file.getName())));
            }
        }
        Author[] authorArr = new Author[authors.size()];
        authorArr = authors.toArray(authorArr);
        return authorArr;
    }

    @Override
    public void addAuthor(Author newAuthor) throws InvalidIdException {
        store.addAuthor(newAuthor);
    }

    @Override
    public Author getAuthorById(int id) throws NoAuthorByIdException {
        return store.getAuthorById(id);
    }

}

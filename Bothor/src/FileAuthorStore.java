import java.io.*;

public class FileAuthorStore implements AuthorStore{

    private String srcDir;
    private static FileAuthorStore INSTANCE;

    private FileAuthorStore(String srcDir){
        this.srcDir = srcDir;
        File newSrcDir = new File(srcDir+"/authors");
        newSrcDir.mkdir();
    }

    public static FileAuthorStore getInstance(String srcDir){
        if(INSTANCE == null){
            INSTANCE = new FileAuthorStore(srcDir);
        }
        return INSTANCE;
    }

    @Override
    public Author getAuthorById(int id) throws NoAuthorByIdException {
        try {
            FileReader fileReader = new FileReader(srcDir + "/authors/" + id + "/author.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String firstName;
            String lastName;
            int birthYear;
            try {
                firstName = bufferedReader.readLine();
                lastName = bufferedReader.readLine();
                birthYear = Integer.parseInt(bufferedReader.readLine());
                bufferedReader.close();
                return new Author(id, firstName, lastName, birthYear);
            }catch (IOException e){
                System.out.println("IOException - FileAuthorStore getAuthorById");
            }
        }catch (FileNotFoundException e){
            throw new NoAuthorByIdException("No author by "+id+" yet.");
        }
        return null;
    }

    @Override
    public void addAuthor(Author a) throws InvalidIdException{
        try{
            FileReader fileReader = new FileReader(srcDir + "/authors/" + a.getId() + "/author.txt");
            throw new InvalidIdException("Author is already in the database.");
        }catch (FileNotFoundException e){
            File newDir = new File(srcDir+"/authors/"+a.getId());
            newDir.mkdir();
            try {
                FileWriter fileWriter = new FileWriter(srcDir + "/authors/" + a.getId() + "/author.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(a.getFirstName());
                bufferedWriter.newLine();
                bufferedWriter.write(a.getLastName());
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(a.getBirthyear()));
                bufferedWriter.close();
            }catch (IOException e2){
                System.out.println("IOException - FileAuthorStore addAuthor");
            }
        }
    }

}

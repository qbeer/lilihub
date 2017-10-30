/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.io.IOException;

/**
 *
 * @author PNMINH
 */
public class BookStoreMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InValidISBNException, IOException {
        // TODO code application logic here
        Book book1 = new Book("Cars","123",123);
        Book book2 = new Book("Motor","345",123);
        Book book3 = new Book("Bike","456",234);
        
        BookServiceInterfaceImpl bookService = new BookServiceInterfaceImpl();
        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        try{
        bookService.getBookStore().writeToFile("D:\\book\\book.txt");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

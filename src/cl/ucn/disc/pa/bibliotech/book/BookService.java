package cl.ucn.disc.pa.bibliotech.book;

import cl.ucn.disc.pa.bibliotech.user.User;

import java.util.List;

/**
 * The main system for manipulate book
 */

public interface BookService {

    /**
     * Search a book by her isbn
     * @param isbn the isbn book
     * @return the book, null if the book is not found
     */

    Book searchByIsbn(String isbn);

    /**
     * Add book at the system
     * @param book the book
     * @return true if the book is added
     */

    boolean add(Book book);

    /**
     * Added book at the system
     * @return the list books
     */

    List<Book> getBooks();

    /**
     * lend a book
     * @param isbn the isbn
     * @param user the user
     * @return true if correct
     */

    boolean lend(String isbn, User user);

    /**
     * rent a book
     * @param isbn the isbn
     * @param user the user
     * @return
     */

    boolean rent(String isbn, User user);

    /**
     * return a book
     * @param isbn the isbn
     * @param user the user
     * @return
     */

    boolean returnBook(String isbn, User user);

}

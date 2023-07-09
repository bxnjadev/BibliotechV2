package cl.ucn.disc.pa.bibliotech.book;

import cl.ucn.disc.pa.bibliotech.user.User;

public interface BookService {

    Book searchByIsbn(String isbn);

    boolean add(Book book);

    boolean lend(String isbn, User user);

    boolean rent(String isbn, User user);

    boolean returnBook(String isbn, User user);

}

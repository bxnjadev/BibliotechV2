package cl.ucn.disc.pa.bibliotech.book;

import cl.ucn.disc.pa.bibliotech.user.User;

import java.util.ArrayList;
import java.util.List;

public class DefaultBookService implements BookService {

    private final List<Book> books;

    public DefaultBookService() {
        books = new ArrayList<>();
    }

    @Override
    public Book searchByIsbn(String isbn) {
        return books.stream().filter(book -> {
            String isbnBook = book.getISBN();
            return isbn.equals(isbnBook);
        }).findFirst().orElse(null);
    }

    @Override
    public boolean add(Book book) {
        return books.add(book);
    }

    @Override
    public boolean lend(String isbn, User user) {
        return false;
    }

    @Override
    public boolean rent(String isbn, User user) {
        return false;
    }

    @Override
    public boolean returnBook(String isbn, User user) {
        return false;
    }

}

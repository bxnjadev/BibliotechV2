package cl.ucn.disc.pa.bibliotech.book;

import cl.ucn.disc.pa.bibliotech.user.User;

import java.util.ArrayList;
import java.util.List;

public class DefaultBookService implements BookService {

    private final List<Book> books;

    public DefaultBookService(List<Book> books) {
        this.books = books;
        System.out.println(books.size());
    }

    @Override
    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean add(Book book) {
        return books.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return books;
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

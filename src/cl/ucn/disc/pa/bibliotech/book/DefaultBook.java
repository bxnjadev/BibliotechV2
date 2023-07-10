package cl.ucn.disc.pa.bibliotech.book;

import java.util.stream.Stream;

public class DefaultBook implements Book {

    private final String isbn;
    private final String author;
    private final String name;
    private final String category;
    private final int pages;
    private final int stock;

    public DefaultBook(String isbn, String author,
                       String name, String category,
                       int pages, int stock) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
        this.category  =category;
        this.pages = pages;
        this.stock = stock;

        System.out.println("Creating book: " + isbn);
    }

    @Override
    public String getISBN() {
        return isbn;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public int getPages() {
        return pages;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public boolean hasStock() {
        return stock > 0;
    }
}

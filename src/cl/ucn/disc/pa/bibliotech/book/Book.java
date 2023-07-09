package cl.ucn.disc.pa.bibliotech.book;

public interface Book {

    String getISBN();

    String getAuthor();

    String getName();

    String getCategory();

    int getPages();

    int getStock();

    boolean hasStock();

}

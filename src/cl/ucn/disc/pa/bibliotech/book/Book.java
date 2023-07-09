package cl.ucn.disc.pa.bibliotech.book;

public interface Book {

    String getCode();

    String getISBN();

    String getName();

    String getCategory();

    int getPages();

    int getStock();

    boolean hasStock();

}

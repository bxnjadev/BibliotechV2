package cl.ucn.disc.pa.bibliotech.book;

/**
 * The book object, contains data of a book
 */

public interface Book {

    /**
     * get the isbn book
     * @return the isbn book
     */

    String getISBN();

    /**
     * get the author book
     * @return the author book
     */

    String getAuthor();

    /**
     * get the name book
     * @return the name book
     */

    String getName();

    /**
     * get the category book
     * @return the category book
     */

    String getCategory();

    /**
     * get the pages book
     * @return the pages book
     */

    int getPages();

    /**
     * get the stock
     * @return the stock
     */

    int getStock();

    /**
     * check book has stock
     * @return true if the book has stock
     */

    boolean hasStock();

}

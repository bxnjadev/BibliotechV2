package cl.ucn.disc.pa.bibliotech.book;

public interface BorrowedBook {

    TransactionType getType();

    String getRutSeller();

    String getName();

    String getLastName();

    String getIsbn();

    String getBookName();

}

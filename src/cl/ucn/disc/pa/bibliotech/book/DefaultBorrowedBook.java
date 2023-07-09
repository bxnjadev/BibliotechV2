package cl.ucn.disc.pa.bibliotech.book;

public class DefaultBorrowedBook implements BorrowedBook {

    private final TransactionType type;
    private final String rutSeller;
    private final String name;
    private final String lastName;
    private final String isbn;
    private final String bookName;

    public DefaultBorrowedBook(TransactionType type, String rutSeller,
                               String name, String lastName, String isbn, String bookName) {
        this.type = type;
        this.rutSeller = rutSeller;
        this.name = name;
        this.lastName = lastName;
        this.isbn = isbn;
        this.bookName = bookName;
    }

    @Override
    public TransactionType getType() {
        return type;
    }

    @Override
    public String getRutSeller() {
        return rutSeller;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getBookName() {
        return bookName;
    }

}
